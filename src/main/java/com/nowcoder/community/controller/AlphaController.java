package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String find(){
        return alphaService.find();
    }
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        //第一行的数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());//获取请求的路径
        //请求头的数据
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+": "+value);
        }
        //请求体的数据
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter printWriter = response.getWriter();){ //java7新语法 只要括号里有close方法就不用再写finally了

            printWriter.write("<h1>牛客网</h1>");
        }
        catch (IOException e){
            e.printStackTrace();

        }


    }

    //GET
    //查询students 当前第几页 每页显示20个数据
    // /students?current=1&limit=20
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current",required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit",required = false,defaultValue = "10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }
    //第二种传参的方式 放在路径中
    // /student/123
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public  String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //POST
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    //响应html数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    //不加注解 默认返回html
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name","zhangsan");
        mav.addObject("age","30");
        //设置模板的路径和名字
        mav.setViewName("/demo/view");//指的是view.html
        return mav;
    }
    //第二种
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){//返回的是view的路径 model的引用是dispatch持有的
        model.addAttribute("name","pek");
        model.addAttribute("age","100");
        return "/demo/view";
    }

    //响应JSON数据（异步请求） 当前网页不刷新 但访问了服务器 返回了结果
    //java对象-> Json字符串 -> JS对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    //会自动把这个map转成一个JSON字符串返回给浏览器
    public Map<String,Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","zhangsan");
        emp.put("age","23");
        emp.put("salary","100000.00");
        return emp;
    }
    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    //会自动把这个map转成一个JSON字符串返回给浏览器
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","zhangsan");
        emp.put("age","23");
        emp.put("salary","100000.00");
        list.add(emp);

        emp.put("name","zhangsan1");
        emp.put("age","231");
        emp.put("salary","100000.001");
        list.add(emp);

        emp.put("name","zhangsan2");
        emp.put("age","232");
        emp.put("salary","100000.0022");
        list.add(emp);
        return list;
    }

}
