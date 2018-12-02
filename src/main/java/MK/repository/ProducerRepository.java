package MK.repository;

import MK.model.Producer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProducerRepository extends AbstractGenericRepository<Producer> implements ProducerInterface {

    public List<Producer> importProducerFromFile(String filename) {
        File file = new File(filename);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Producer> producers = new ArrayList<>();
        while (sc.hasNextLine()) {
            String data[] = sc.nextLine().split(";");
            Producer producer = Producer.builder()
                    .name(data[0])
                    .build();
            producers.add(producer);
        }
        return producers;
    }

    public void enterDataProducerToDataBase() {
        List<Producer> producers = importProducerFromFile("C:/Users/Karol/IdeaProjects/testowanie_projekt2/src/main/java/resources/producers.txt");
        System.out.println("list=" + producers);
        for (int i = 0; i < producers.size(); i++) {
            saveOrUpdate(producers.get(i));
        }
    }
}
