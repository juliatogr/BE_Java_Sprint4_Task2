package cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01.model.repository.FruitaRepository;

@Service
public class FruitaService {
    @Autowired
    FruitaRepository fruitaRepository;
    
    public List<Fruita> getAllFruites(){
        return (ArrayList<Fruita>) fruitaRepository.findAll();
    }

    public Fruita createFruita(Fruita fruita){
        return fruitaRepository.save(fruita);
    }

    public Optional<Fruita> getFruitaById(int id){
        return fruitaRepository.findById(id);
    }

    public List<Fruita> getFruitaByNom(String nom) {
        return fruitaRepository.findByNomContaining(nom);
    }

    public boolean deleteFruita(int id) {
        try{
        	fruitaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}
