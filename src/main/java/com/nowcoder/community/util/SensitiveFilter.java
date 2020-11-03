package com.nowcoder.community.util;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class SensitiveFilter {

    private static final Logger logger= LoggerFactory.getLogger(SensitiveFilter.class);
    //替换符
    private static final String REPLACEMENT="***";

    //根节点
    private TrieNode rootNode = new TrieNode();

    //表示这是个初始化方法 当容器实例化这个Bean以后（服务启动） 在调用这个构造器之后 自动执行这个方法
    @PostConstruct
    public void init(){
        try(InputStream is= this.getClass().getClassLoader().getResourceAsStream("sensitive-words.txt");
            //看target classes 有敏感词的txt
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        ) {
                String keyword;
                while((keyword=reader.readLine())!=null){
                    //添加到前缀树
                    this.addKeyword(keyword);
                }
             }
        catch (IOException e){
            logger.error("加载敏感词文件失败："+e.getMessage());
        }


    }
    //将一个敏感词添加到前缀树中
    private void addKeyword(String keyword){
        TrieNode tempNode = rootNode;
        for(int i=0;i<keyword.length();i++){
            char c=keyword.charAt(i);
           TrieNode subNode=tempNode.getSubNode(c);
           if(subNode==null){
               //初始化子节点
               subNode=new TrieNode();
               tempNode.addSubNode(c,subNode);
           }
           tempNode=subNode;
           //设置结束的标识
            if(i==keyword.length()-1)
            {
                tempNode.setKeyEnd(true);
            }

        }

    }

    /**
     * 过滤敏感词
     * @param text 带过滤的文本
     * @return 过滤后的文本
     */
    public String filter(String text){
        if(StringUtils.isBlank(text))
            return null;
        //指针1 根节点
        //每次在目标字符串中找到一个敏感词，完成替换之后，都要再次从根节点遍历树开始新一次过滤
        TrieNode tempNode = rootNode;
        //begin指针作用是目标字符串每次过滤的开头
        int begin=0;
        //position作用是指向待过滤的字符
        //若position指向的是一个敏感词结尾 text.subString(begin,position+1)就是敏感词
        int position=0;
        StringBuilder result=new StringBuilder();

        while(position<text.length()){
            char c=text.charAt(position);
            //忽略用户故意输入的符号 例如嫖※娼 忽略※后 前后字符其实也是敏感词
            if (isSymbol(c)){
                //判断当前节点是否为根节点
                //若是根节点，代表依次新的过滤刚开始，可以直接将该特殊符号字符放入到结果字符串中
                if(tempNode==rootNode){
                    result.append(c);
                    begin++;
                }
                position++;
                continue;
            }
            //判断当前节点的子节点是否有目标字符c
            //如果没有 代表当前begin-position之间的字符串不是敏感词
            // 但begin+1-position却不一定不是敏感词 所以begin position 都移到++begin tempnode回到根
            tempNode = tempNode.getSubNode(c);
            if(tempNode==null){
                result.append(text.charAt(begin));
                position=++begin;
                tempNode=rootNode;
            }
            else if(tempNode.isKeyEnd()){
                //如果找到了子节点且子节点是敏感词的结尾
                //则当前begin-position间的字符串是敏感词 将敏感词替换掉
                result.append(REPLACEMENT);
                begin=++position;
                tempNode=rootNode;
            }
            else if(position+1==text.length()){
                //特殊情况
                //虽然position指向的字符在树中存在，但不是敏感词结尾，并且position到了目标字符串末尾（这个重要）
                //因此begin-position之间的字符串不是敏感词 但begin+1-position之间的不一定不是敏感词
                //所以只将begin指向的字符放入过滤结果
                result.append(text.charAt(begin));
                //position和begin都指向begin+1
                position = ++begin;
                //再次过滤
                tempNode = rootNode;
            }
            else {
                position++;
            }
        }
        return begin<text.length()?result.append(text.substring(begin)).toString():result.toString();

    }

    //判断是不是符号
    private boolean isSymbol(Character c){
        return !CharUtils.isAsciiAlphanumeric(c) && (c<0x2E80 || c>0x9FFF);
        //判断是不是普通字符ABC就是true 如果是特殊字符就返回false
        //0x2E80~0x9FFF 东亚文字范围
    }



    //前缀树
    private class TrieNode{
        //关键词结束的标识
        private boolean isKeyEnd = false;
        //子节点(key是下级字符，value是下级节点)
        private Map<Character,TrieNode> subNodes=new HashMap<>();

        public boolean isKeyEnd() {
            return isKeyEnd;
        }

        public void setKeyEnd(boolean keyEnd) {
            isKeyEnd = keyEnd;
        }

        //添加子节点
        public void addSubNode(Character s ,TrieNode node){
            subNodes.put(s,node);
        }
        //获取子节点
        public TrieNode getSubNode(Character c){
            return subNodes.get(c);
        }



    }
}
