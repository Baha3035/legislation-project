package alatoo.kg.legislations.controllers;

import alatoo.kg.legislations.models.dto.LegislationDto;
import alatoo.kg.legislations.models.entities.Legislation;
import alatoo.kg.legislations.models.entities.User;
import alatoo.kg.legislations.services.LegislationService;
import alatoo.kg.legislations.services.TagService;
import alatoo.kg.legislations.services.UserService;
import alatoo.kg.legislations.services.serviceImpl.LegislationServiceImpl;
import alatoo.kg.legislations.services.serviceImpl.UserServiceImpl;
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
    private LegislationServiceImpl legislationServiceImpl;
    @Autowired
    UserService userService;
    @Autowired
    private TagService tagService;


    @GetMapping("/all")
    public ResponseEntity<List<LegislationDto>> findAll(@RequestHeader(name = "Authorization") String token){
        User user = userService.getUsernameFromToken(token);
        return ResponseEntity.ok(legislationServiceImpl.findAll());
    }

    @PostMapping("/save")
    public void save(@RequestHeader(name = "Authorization") String token ,@RequestBody LegislationDto legislationDto){
        User user = userService.getUsernameFromToken(token);
         legislationServiceImpl.save(legislationDto);
    }

    @GetMapping("/findLegislationDtosByTagId")
    List<LegislationDto> findLegislationDtosByTagId(@RequestParam Long id){
        return tagService.findLegislationDtosByTagId(id);
    }
}
