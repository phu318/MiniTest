package material;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaterialManager {
    List<Material> materialList = new ArrayList<>();
    public MaterialManager(){
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
    }

    public List<Material> getMaterialList() {
        return materialList;
    }
    public void addMaterial(Material material){
        materialList.add(material);
    }
    public List<Material> getAll(){
        return materialList;
    }
    public void removeMaterialByMyCode(String id){
        for (Material material : materialList) {
            if (material.getId().equals(id)) {
                materialList.remove(material);
                break;
            }
        }
    }
    public void updateMaterialById(String id, Material materialEdit) {
        List<Material> materials = getAll();
        for (int i = 0; i < materials.size() ; i++) {
            if (materials.get(i).getId().equals(id)){
                materials.set(i,materialEdit);
            }
        }

    }
}
