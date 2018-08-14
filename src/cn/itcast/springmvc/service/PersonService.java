package cn.itcast.springmvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.itcast.springmvc.domain.Person;

@Service
public class PersonService {
    //��ʼ����Ϣ
    private static Integer id = 0;
    private static Map<Integer,Person> map = new HashMap<Integer,Person>();
    static{
        Person p = null;
        for(int i=0;i<10;i++){
            p = new Person();
            
            p.setId(id);
            p.setName("tony"+i);
            p.setAge(20+i);
            
            map.put(p.getId(), p);
            
            id++;
        }
    }
    
    //�б�
    public List<Person> listAll(){
        return new ArrayList(map.values());
    }
    
    //��ȡ����
    public Person get(Integer id){
        return map.get(id);
    }
    
    //����
    public void save(Person p){
        if(p.getId()==null){
            id++;
            p.setId(id);
        }
        map.put(p.getId(), p);
    }
    
    //ɾ��
    public void deleteById(Integer id){
        map.remove(id);
    }

    
}