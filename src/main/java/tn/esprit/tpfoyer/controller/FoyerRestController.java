package tn.esprit.tpfoyer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IBlocService;
import tn.esprit.tpfoyer.service.IFoyerService;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    @Autowired
    IFoyerService foyerService;
    @Autowired
    IBlocService blocService;
    @Autowired
    public FoyerRestController(IFoyerService foyerService){
        this.foyerService = foyerService;
    }

    @GetMapping("/retrieve-all-foyer")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyer = foyerService.retrieveAllFoyer();
        return listFoyer;
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") long fId) {
        return foyerService.retrieveFoyer(fId);
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer c){
        return foyerService.addFoyer(c);
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") long fId) {
        foyerService.removeFoyer(fId);
    }

    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        Foyer foyer = foyerService.modifyFoyer(f);
        return foyer;
    }

    @PostMapping("/add-foyer-blocs")
    public void addFoyerBlocs(@RequestBody Foyer f){
        foyerService.addFoyer(f);
        for(var b : f.getBlocs()){
            b.setFoyer(f);
            blocService.addBloc(b);
        }
    }
}
