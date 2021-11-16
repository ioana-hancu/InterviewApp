package interviewapp.persistence;

import interviewapp.domain.Candidate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private CandidateRepository candidateRepository;

    public DbSeeder(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void  run(String... strings) throws Exception{
        Candidate A = new Candidate(firstname: "Alex", lastname: "Calinescu", age: 23);
        Candidate B = new Candidate(firstname: "Ionut", lastname: "Silvestru", age: 25);
        Candidate C = new Candidate(firstname: "George", lastname: "Rosu", age: 29);
        Candidate D = new Candidate(firstname: "Silviu", lastname: "Coman", age: 26);

        List<Candidate> candidates = new ArrayList<>();
        candidates.add(A);
        candidates.add(B);
        candidates.add(C);
        candidates.add(D);

        this.candidateRepository.save();
    }
}
