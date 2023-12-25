import material.CrispyFlour;
import material.Material;
import material.MaterialManager;
import material.Meat;

import java.time.LocalDate;
import java.util.*;

public  class Main {
   static MaterialManager materialManager  = new MaterialManager();
    public static void main(String[] args) {


        int choice;
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("MENU");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm");
            System.out.println("5. Tính tổng giá tiền");
            System.out.println("6. Tính số chênh lệch");
            System.out.println("7. Thoát");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addMaterial();
                    break;
                case 2:
                    removeMaterialByCode();
                    break;
                case 3:
//                    updateMaterialById(materialList,"2");
                    break;
                case 4 :
//                    sortByPrice(materialList);
                    break;
                case 5 :
//                    System.out.println("Tổng tiền của các sản phẩm là " + totalCostMaterial(materialList));
                    break;
                case 6:
//                    System.out.println("Tỉ số chênh lêch là " + calendarDifference(materialList));
                    break;
                case 7:
                    flag = true;
                    break;
                default:
                    System.out.println(" Sụ lựa chọn của bạn không hợp lệ");
            }
        }while (!flag);
    }




    public static void displayMaterial(List<Material> materialList) {
        for (Material material : materialList) {
            System.out.println(material.toString());
        }
    }

    public static void addMaterial() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn vui lòng nhập thông tin muốn thêm");
        System.out.println("Nhập mã code");
        String id = scanner.nextLine();
        System.out.println("Nhập tên ");
        String name = scanner.nextLine();
        LocalDate.now();
        System.out.println("Nhập giá");
        int cost = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập số lượng");
        long quantity = scanner.nextLong();

        Material material = new CrispyFlour(id,name,LocalDate.now(),cost,quantity);
       materialManager.addMaterial(material);
       displayMaterial(materialManager.getAll());
    }

    public static void removeMaterialByCode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập sản phẩm có ID bạn muốn xóa");
        String id = scanner.nextLine();
        materialManager.removeMaterialByMyCode(id);
        displayMaterial(materialManager.getAll());
    }

    public static void updateMaterialById(List<Material> materialList, String id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ID sản phẩm bạn muốn sửa:");
        id = scanner.nextLine();

        for (Material material : materialList) {
            if (material.getId().equals(id) && material instanceof CrispyFlour) {
                CrispyFlour crispyFlour = (CrispyFlour) material;
                System.out.println("Nhập thông tin mới cho sản phẩm:");
                System.out.print("Tên mới: ");
                String newName = scanner.nextLine();
                System.out.println("Giá mới: ");
                int newCost = Integer.parseInt(scanner.nextLine());
                System.out.print("Số lượng mới: ");
                long newQuantity = Long.parseLong(scanner.nextLine());

                material.setName(newName);
                material.setCost(newCost);
                ((CrispyFlour) material).setQuantity(newQuantity);

                System.out.println("Sửa thông tin sản phẩm thành công.");
                System.out.println(" ");
                System.out.println(" Danh sách sản phẩm mới là: ");
                displayMaterial(materialList);
                return;
            }
        }
    }

    public static void sortByPrice(List<Material> materialList) {
        Comparator<Material> priceComparator = Comparator.comparing(Material::getCost);
        Collections.sort(materialList, priceComparator);
        displayMaterial(materialList);
    }

    public static int totalCostMaterial(List<Material> materialList) {
        int totalMeat = 0;
        int totalCrispyFlour = 0;
        for (Material material : materialList) {
            if (material instanceof CrispyFlour) {
                CrispyFlour crispyFlour = (CrispyFlour) material;
                totalCrispyFlour += material.getAmount();
            } else if (material instanceof Meat) {
                Meat meat = (Meat) material;
                totalMeat += material.getAmount();
            }

        }
        int total = totalMeat + totalCrispyFlour;
        return total;
    }

    public static double calendarDifference(List<Material> materialList) {
        double diffenceNum = 0;
        for (Material material : materialList) {
            if (material instanceof Meat) {
                Meat meat = (Meat) material;
                diffenceNum += (material.getAmount() - material.getRealMoney());
            } else if (material instanceof CrispyFlour) {
                CrispyFlour crispyFlour = (CrispyFlour) material;
                diffenceNum += (material.getAmount() - material.getRealMoney());
            }
        }
        return diffenceNum;
    }


}
