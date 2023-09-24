package alatoo.kg.legislations.controllers;

import alatoo.kg.legislations.models.dto.LegislationDto;
import alatoo.kg.legislations.models.entities.Legislation;
import alatoo.kg.legislations.models.entities.User;
import alatoo.kg.legislations.services.LegislationService;
import alatoo.kg.legislations.services.TagService;
import alatoo.kg.legislations.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/legislations")
public class LegislationController {
    @Autowired
    private LegislationService legislationService;

    @Autowired
    private TagService tagService;

//    @GetMapping("/getTokenCheck")
//    public ResponseEntity<Collection<Legislation>> getAllLegislations(@RequestHeader(name = "Authorization") String token){
//        User user = userService.getUsernameFromToken(token);
//        return ResponseEntity.ok(legislationService.getAllLegislations());
//    }

    @GetMapping("/all")
    public List<LegislationDto> findAll(){
        return legislationService.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody LegislationDto legislationDto){
         legislationService.save(legislationDto);
    }

    @GetMapping("/findLegislationDtosByTagId")
    List<LegislationDto> findLegislationDtosByTagId(@RequestParam Long id){
        return tagService.findLegislationDtosByTagId(id);
    }
}
