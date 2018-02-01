package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("/Users/admin/Desktop/сериализNEW.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
//        System.out.println("qwd");
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() { }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

//        public void save(OutputStream outputStream) throws Exception {
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//            writer.write(name+"\n");
//            writer.write(assets.size()+"\n");
//            for (Asset asset : assets)
//                writer.write(asset.getName() + "\n" + asset.getPrice() + "\n");
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            name = reader.readLine();
//            int countOfAssets = Integer.parseInt(reader.readLine());
//            for(int i=0;i<countOfAssets;i++)
//                assets.add(new Asset(reader.readLine(),Double.parseDouble(reader.readLine())));
//        }

        public void save(OutputStream outputStream) throws Exception {
            OutputStreamWriter bw = new OutputStreamWriter(outputStream);
            bw.write(name+"\n",0,name.length()+1);
            for(Asset a: assets){
                String as = a.getName() + " " + a.getPrice() +"\n";
                bw.write(as,0,as.length());
            }
            bw.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            name = reader.readLine();
            while (reader.ready()) {
                String as = reader.readLine();
                assets.add(new Asset(as.split(" ")[0], Double.parseDouble(as.split(" ")[1])));
            }
        }






        }
}
