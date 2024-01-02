import model.CrispyFlour;
import model.Material;
import model.MaterialDTO;
import model.Meat;
import utils.Config;
import utils.FileUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    List<Material> materialList = new ArrayList<>();
    public void init(){
        LocalDate today = LocalDate.of(2023, 11, 12);
        materialList.add(new CrispyFlour("1", "bot mi", today, 100, 5));
        materialList.add(new CrispyFlour("2", "bot nang", today, 200, 4));
        materialList.add(new CrispyFlour("3", "bot loc", today, 300, 3));
        materialList.add(new CrispyFlour("4", "bot nep", today, 400, 2));
        materialList.add(new CrispyFlour("5", "bot gao", today, 500, 1));
        materialList.add(new Meat("6", "thit ga", today, 100, 10));
        materialList.add(new Meat("7", "thit heo", today, 200, 12));
        materialList.add(new Meat("8", "thit cho", today, 300, 100));
        materialList.add(new Meat("9", "thit chim", today, 800, 12));
        materialList.add(new Meat("10", "thit ho", today, 1100, 30));
        FileUtils.writeFile(materialList, Config.PATH_FILE_MATERIAL);
    }

    public List<Material> getMaterialList() {
        return materialList;
    }
    public void addMaterial(Material material){

        materialList.add(material);
        FileUtils.writeFile(materialList, Config.PATH_FILE_MATERIAL);
    }
    public List<Material> getAll(){
        List<MaterialDTO> list = FileUtils.readFile(Config.PATH_FILE_MATERIAL,MaterialDTO.class);


        return FileUtils.readFile(Config.PATH_FILE_MATERIAL,Material.class);
    }
    public void removeMaterialByMyCode(String id){
        for (Material material : materialList) {
            if (material.getId().equals(id)) {
                materialList.remove(material);
                FileUtils.writeFile(materialList, Config.PATH_FILE_MATERIAL);
                break;
            }
        }
    }
    public void updateMaterialById(String name, int cost,long quantity) {

    }


}
