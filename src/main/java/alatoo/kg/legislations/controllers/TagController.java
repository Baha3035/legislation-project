package alatoo.kg.legislations.controllers;

import alatoo.kg.legislations.models.dto.TagDto;
import alatoo.kg.legislations.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
public class TagController {
    @Autowired
    private TagService tagService;
    @PostMapping("/save")
    TagDto save(@RequestBody TagDto tagDto){
        return tagService.save(tagDto);
    }

    @GetMapping("/all")
    List<TagDto> findAll(){
        return tagService.findAll();
    }
}
