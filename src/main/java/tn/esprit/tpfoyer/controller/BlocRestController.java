package tn.esprit.tpfoyer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    IBlocService foyerService;
    @Autowired
    IBlocService blocService;
    @Autowired
    public BlocRestController(IBlocService blocService){
        this.blocService = blocService;
    }

    @GetMapping("/retrieve-all-bloc")
    public List<Bloc> getBlocs() {
        List<Bloc> listBloc = blocService.retrieveAllBloc();
        return listBloc;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") long bId) {
        return blocService.retrieveBloc(bId);
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc c){
        return blocService.addBloc(c);
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") long fId) {
        blocService.removeBloc(fId);
    }

    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc f) {
        Bloc bloc = blocService.modifyBloc(f);
        return bloc;
    }

   /*
   @PostMapping("/add-bloc-blocs")
    public void addBlocBlocs(@RequestBody Bloc f){
        for(var b : f.getBlocs()){
            blocService.addBloc(b);
        }
        blocService.addBloc(f);
    }
    */
}
