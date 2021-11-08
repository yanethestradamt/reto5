
package RetoFinal.Reto3Grupo8;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioMoto {
    
    @Autowired
    private InterfaceMoto crud;

    public List<Moto> getAll(){
        return (List<Moto>) crud.findAll();
    }

    public Optional<Moto> getMoto(int id){
        return crud.findById(id);
    }

    public Moto save(Moto moto){
        return crud.save(moto);
    }
    public void delete(Moto moto){
        crud.delete(moto);
    }
    
}
