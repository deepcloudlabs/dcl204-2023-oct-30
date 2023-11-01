import com.example.random.service.RandomNumberGeneratorService;

module com.example.lottery {
	requires com.example.random;
	uses RandomNumberGeneratorService;
}