package com.example.api;

import com.example.entity.Personal;
import com.example.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/personal")
@RequiredArgsConstructor
public class PersonalController {
    private final PersonalRepository personalRepository;

    @PostConstruct
    public void init(){
        Personal personal=new Personal();
        personal.setName("ozdemir");
        personal.setSurname("sahin");
        personal.setBirthDate(Calendar.getInstance().getTime());
        personal.setId("001");
        personalRepository.save(personal);

        Personal personal1=new Personal();
        personal1.setName("murat");
        personal1.setSurname("sahin");
        personal1.setBirthDate(Calendar.getInstance().getTime());
        personal1.setId("002");
        personalRepository.save(personal1);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Personal>> getPersonal(@PathVariable String search){
        List<Personal> personals= personalRepository.findByNameLikeOrSurnameLike(search,search);

        return ResponseEntity.ok(personals);
    }
}
