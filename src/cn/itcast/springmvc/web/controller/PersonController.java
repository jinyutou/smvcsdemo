package cn.itcast.springmvc.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.springmvc.domain.Person;
import cn.itcast.springmvc.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService ps;
    
    
    //�б�
    @RequestMapping("/listAll")
    public String listAll(Map<String,Object> model){
        List<Person> personList = ps.listAll();
        model.put("personList", personList);
        
        System.out.println(" listall hello");
        
        return "person/jPersonList";
    }
    
    //�б�
    @RequestMapping("/listAllOther")
    public String listAllOther(Model model){
        List<Person> personList1 = ps.listAll();
        model.addAttribute(personList1);
        
        System.out.println(" listallother1 hello");
        
        return "person/jPersonList";
    }
    
    //ת������ҳ��
    @RequestMapping(value={"/tocreate"},method=RequestMethod.GET)
    public String tocreate(){
        
        return "person/jPersonCreate";
    }
    
    //ת���޸�ҳ��
    @RequestMapping("/toupdate")
    public String toupdate(Integer id, Model model){
        Person p = ps.get(id);
        model.addAttribute(p);
        
        return "person/jPersonUpdate";
    }
    
    //����
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(  HttpServletRequest request,@Valid Person p, BindingResult br, @RequestParam MultipartFile photo) throws IOException{
        //������
        if(br.hasErrors()){
            return "/person/jPersonUpdate";
        }
        
        //�ϴ�ͼƬ
        ServletContext sc = request.getSession().getServletContext();
        String dir = sc.getRealPath("/upload/");
        String fileName = photo.getOriginalFilename();
        System.out.println("========dir========>"+dir);
        System.out.println("========fileName========>"+fileName);
        
        //��ֹͼƬ����
        Long _l = System.nanoTime();
        String _extName = fileName.substring(fileName.indexOf("."));
        fileName = _l + _extName;
        
        FileUtils.writeByteArrayToFile(new File(dir, fileName), photo.getBytes());
        
        p.setPhotoPath("/upload/"+fileName);        //ָ��ͼƬ����·��
        
        ps.save(p);
        return "redirect:/person/listAll.do";
    }
    
    //ɾ��
    @RequestMapping("/delete")
    public String delete(@RequestParam("delId")Integer id){
        ps.deleteById(id);
        return "redirect:/person/listAll.do";
    }
}