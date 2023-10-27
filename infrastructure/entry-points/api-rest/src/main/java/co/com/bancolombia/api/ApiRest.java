package co.com.bancolombia.api;
import co.com.bancolombia.model.animal.Animal;
import co.com.bancolombia.usecase.animal.AnimalUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final AnimalUseCase crudAnimalUseCase;

    @GetMapping(path = "/path")
    public String commandName() {
//      return useCase.doAction();
        return "HelloWorld";
    }
    @GetMapping(path = "/consultar/{id}")
    public Animal read(@PathVariable String id){ return crudAnimalUseCase.read(id);}
    @PostMapping(path ="/create")
    public void create(@RequestBody Animal animal){
        try {
            crudAnimalUseCase.create(animal);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }

    }
    @PutMapping(path = "/actualizar/{id}")
    public void update (@PathVariable String id,@RequestBody Animal animal){
        try {
            crudAnimalUseCase.update(id,animal);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }
    @DeleteMapping(path = "/borrar/{id}")
    public void delete(@PathVariable String id){crudAnimalUseCase.delete(id);}
    @GetMapping(path = "/list")
    public List<Animal> getAll(){return crudAnimalUseCase.getAll();}
}
