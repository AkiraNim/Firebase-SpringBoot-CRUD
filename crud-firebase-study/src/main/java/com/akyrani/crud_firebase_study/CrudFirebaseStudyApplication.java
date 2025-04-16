package com.akyrani.crud_firebase_study;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class CrudFirebaseStudyApplication {

	public static void main(String[] args) throws IOException {
		InputStream serviceAccount = CrudFirebaseStudyApplication.class
				.getClassLoader()
				.getResourceAsStream("serviceAccountKey.json");

		if (serviceAccount == null) {
			throw new FileNotFoundException("Arquivo serviceAccountKey.json não encontrado no classpath!");
		}

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://crud-firebase-api-56e71-default-rtdb.firebaseio.com")
				.build();

		FirebaseApp.initializeApp(options);



		SpringApplication.run(CrudFirebaseStudyApplication.class, args);
	}

}
