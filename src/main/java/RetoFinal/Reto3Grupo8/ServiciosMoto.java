
package RetoFinal.Reto3Grupo8;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosMoto {
     @Autowired
    private RepositorioMoto metodosCrud;

    public List<Moto> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Moto> getMoto(int machineId) {
        return metodosCrud.getMoto(machineId);
    }

    public Moto save(Moto moto){
        if(moto.getId()==null){
            return metodosCrud.save(moto);
        }else{
            Optional<Moto> e=metodosCrud.getMoto(moto.getId());
            if(e.isEmpty()){
                return metodosCrud.save(moto);
            }else{
                return moto;
            }
        }
    }

    public Moto update(Moto moto){
        if(moto.getId()!=null){
            Optional<Moto> e=metodosCrud.getMoto(moto.getId());
            if(!e.isEmpty()){
                if(moto.getName()!=null){
                    e.get().setName(moto.getName());
                }
                if(moto.getBrand()!=null){
                    e.get().setBrand(moto.getBrand());
                }
               
                if(moto.getCategory()!=null){
                    e.get().setCategory(moto.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return moto;
            }
        }else{
            return moto;
        }
    }


    public boolean deleteMoto(int machineId) {
        Boolean aBoolean = getMoto(machineId).map(moto -> {
            metodosCrud.delete(moto);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
