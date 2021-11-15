package android_automation_mobile;

import java.util.Random;

public class GenerateRand {

	public String Generator() {
		Random rand = new Random();
		String email = rand.nextInt(1000)+"piton@gmail.com";
		return email;
	}

}
