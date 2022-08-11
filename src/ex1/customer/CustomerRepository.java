package ex1.customer;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerRepository {

    private static final String FILE_PATH = "src/poly/customer/data.txt";



    public Optional<AbstractCustomer> getCustomerById(String id) {
        try {
            List<String> lines = Files.readAllLines(Path.of(FILE_PATH));
            for (String line : lines) {
                final String[] parts = line.split(";");
                if(parts[0].equals("REGULAR")){
                    if(parts[1].equals(id)){
                        System.out.println("reg");

                        return Optional.of(new RegularCustomer(parts[1], parts[2], Integer.parseInt(parts[3]),LocalDate.parse(parts[4]))); // how to not include order
                    }
                }else {
                    if(parts[1].equals(id)){
                        System.out.println("gold");
                        return Optional.of(new GoldCustomer(parts[1], parts[2], Integer.parseInt(parts[3])));
                    }
                }

            }
        } catch (IOException e) {

        }
        return Optional.empty();

    }

    public void remove(String id) {
        try {
            File file = new File(FILE_PATH);
            List<String> out = Files.lines(file.toPath())
                    .filter(line -> !line.contains(id))
                    .collect(Collectors.toList());
            Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {

        }

    }

    public void save(AbstractCustomer customer) {
            try {
                BufferedWriter out = new BufferedWriter(
                        new FileWriter(FILE_PATH, true));
                try {
                    remove(customer.getId());
                } catch (Exception e) {

                }
                out.write(customer.asString() + "\n");
                out.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");

            }
        }


    public int getCustomerCount() {
        int result = 0;
        try {
            List<String> lines = Files.readAllLines(Path.of(FILE_PATH));
            result = lines.size();
        } catch (IOException e) {

        }
        return result;
    }
}
