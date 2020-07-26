package novi.spring.RISK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private ComputerRepository computerRepository;
    private RandapparatuurRepository randapparatuurRepository;
    private SoftwareRepository softwareRepository;

    //constructor die door @Autowired aangemaakt wordt
    public DatabaseLoader(ComputerRepository computerRepository) {

        this.computerRepository = computerRepository;
    }
    public DatabaseLoader(RandapparatuurRepository randapparatuurRepository) {
        this.randapparatuurRepositor = randapparatuurRepositor;
    }
    public DatabaseLoader(SoftwareRepository softwareRepository) {

        this.softwareRepository = softwareRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Computer computer = new Computer();
        computerRepository.save(computer);

        Randapparatuur randapparatuur = new Randapparatuur();
        randapparatuurRepository.save(randapparatuur);

        Software software = new Software();
        softwareRepository.save(software);

    }
}
