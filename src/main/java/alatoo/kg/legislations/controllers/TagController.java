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

    // make dto to save petition by specifying only image_url. Image should be created during the execution of this method
    // check if find petition by tag_id works
    // make it possible to filter by date, tag, title
    // make dto to save comment by specifying only comment_content. Comment should be created during the execution of this method
}
