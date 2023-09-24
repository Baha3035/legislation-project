package alatoo.kg.legislations.services.serviceImpl;

import alatoo.kg.legislations.dao.ImageRepo;
import alatoo.kg.legislations.mappers.ImageMapper;
import alatoo.kg.legislations.models.dto.ImageDto;
import alatoo.kg.legislations.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepo repo;
    @Override
    public ImageDto save(ImageDto imageDto) {
        return map().toDto(repo.save(map().toEntity(imageDto)));
    }

    @Override
    public ImageDto update(ImageDto imageDto) {
        return null;
    }

    @Override
    public ImageDto findById(Long id) {
        return null;
    }

    @Override
    public List<ImageDto> findAll() {
        return map().toDtoList(repo.findAll());
    }

    ImageMapper map() {
        return new ImageMapper();
    }
}
