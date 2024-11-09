package com.example.demo.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Domain.Studentfees;
import com.example.demo.Respository.feesRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RstController {
    @Autowired
private feesRepo repo;

@GetMapping("/")
public String hello(){
return "Welcome to Student fees portal";
}

@GetMapping("/getFeesDetails")
public List<Studentfees> getFeesDetails(){
   return repo.findAll();
}
@GetMapping("/getStudentFeesDetails/{student_Id}")
public ResponseEntity<Studentfees> getStudentFeesDetails(@PathVariable Integer student_Id){
    Optional<Studentfees> found=repo.findById(student_Id);
        if(found.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found.get());
}

@PostMapping("/payFees")
public ResponseEntity<Studentfees> addFees(@RequestBody Studentfees fees){
Studentfees sf=repo.save(fees);
return ResponseEntity.created(URI.create(sf.getGrade().toString())).body(sf);
}
}



