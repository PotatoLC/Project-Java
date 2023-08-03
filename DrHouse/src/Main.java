import java.util.Scanner;


public class Main {

	public static String pregunta(String p) {
		Scanner sc = new Scanner(System.in);
		System.out.println(p);
		String respuesta = sc.nextLine();
		return respuesta; 
	}
	
	public static void Golpes (String nombre) {
		System.out.println(String.format("\nOk %s, usted mencionó que tuvo una caida", nombre));
		String respuesta = "";
		respuesta = pregunta(String.format("%s, ¿Podria decirme donde fue el golpe? \nH-Cabeza"
		        + "\nC-Pecho\nF-Pies", nombre));
		while (!respuesta.equals("H") && !respuesta.equals("C") && !respuesta.equals("F")) {
		    respuesta = pregunta(String.format("%s, ¿Podria decirme donde fue el golpe? \nH-Cabeza"
		            + "\nC-Pecho\nF-Pies", nombre));
		} if (respuesta.equals("H")) {
		    System.out.println(String.format("\nVaya %s, al parecer te has golpeado la cabeza", nombre));
		    respuesta = pregunta(String.format("%s, ¿Puedes ver bien? [Y/N]", nombre));
		    while (!respuesta.equals("Y") && !respuesta.equals("N")) {
		        respuesta = pregunta(String.format("%s, ¿Puedes ver bien? [Y/N]", nombre));
		    } if (respuesta.equals("N")) {
		        System.out.println(String.format("Vale %s, te mandaré al oculista", nombre));
		    } else if (respuesta.equals("Y")) {
		        System.out.println(String.format("\nVale %s, al parecer estás bien de la vista, te haré otras preguntas", nombre));
		        respuesta = pregunta(String.format("%s, ¿Puedes oir bien? [Y/N]", nombre));
		        while (!respuesta.equals("Y") && !respuesta.equals("N")) {
		            respuesta = pregunta(String.format("\n%s, ¿Puedes oir bien? [Y/N]", nombre));
		        } if (respuesta.equals("Y")) {
		            System.out.println(String.format("\nOk %s, al parecer solo fue un golpe leve, toma paracetamol", nombre));
		        } else if (respuesta.equals("N")) {
		            System.out.println(String.format("\n%s, te mandaré con el otorrinolaringólogo", nombre));
		        }
		    }
		} else if (respuesta.equals("C")){
			System.out.println((String.format("\nVale %s, te golpeaste el Pecho, te haré unas preguntas", nombre)));
			respuesta = pregunta(String.format("%s, ¿Tiene dificultad para respirar? [Y/N]", nombre));
			while (!respuesta.equals("Y") && !respuesta.equals("N")) {
				respuesta = pregunta(String.format("%s, ¿Tiene dificultad para respirar? [Y/N]", nombre));
			} if (respuesta.equals("Y")) {
				System.out.println(String.format("\nVale %s, te mandaré a hacer unos estudios en los pulmones", nombre));
			} else if (respuesta.equals("N")) {
				System.out.println(String.format("\nVale, esto se pone interesante %s, te haré mas preguntas", nombre));
				respuesta = pregunta(String.format("¿Tienes problemas cardiaticos, %s? [Y/N]", nombre));
				while (!respuesta.equals("Y") && !respuesta.equals("N")){
					respuesta = pregunta(String.format("¿Tienes problemas cardiaticos, %s? [Y/N]", nombre));	
				} if (respuesta.equals("Y")) {
					System.out.println(String.format("\nOkey %s, te mandaré al departamento de cardiologia", nombre));
				} else if (respuesta.equals("N")){
					System.out.println(String.format("\nDespués de estas preguntas %s, llegué a la conclusión que fue un golpe leve, te daré una pastilla", nombre));
				}
			}
			
		} else if (respuesta.equals("F")){
			System.out.println(String.format("\nOkey %s, te golpeaste los pies, cuentame un poco mas", nombre));
			respuesta = pregunta(String.format("%s, ¿Practicas algun deporte? [Y/N]", nombre));
			while (!respuesta.equals("Y") && !respuesta.equals("N")) {
				respuesta = pregunta(String.format("\n%s, ¿Practicas algun deporte? [Y/N]", nombre));
			} if (respuesta.equals("Y")) {
				System.out.println(String.format("\n%s, Al parecer tuviste un problema en el entrenamiento, te mandaré una pomada", nombre));
			} else if (respuesta.equals("N")) {
				System.out.println(String.format("\n%s, esto se pone serio", nombre));
				respuesta = pregunta(String.format("%s ¿Tienes enfermedades cronicas? (Diabetes, Artritis, etc) [Y/N]", nombre));
				while (!respuesta.equals("Y") && !respuesta.equals("N")) {
					respuesta = pregunta(String.format("\n%s ¿Tienes enfermedades cronicas? (Diabetes, Artritis, etc) [Y/N]", nombre));
				} if (respuesta.equals("Y")) {
					System.out.println(String.format("\n%s Te mandaré al departamento especial", nombre));
				} else if (respuesta.equals("N")) {
					System.out.println(String.format("\nOkey %s, solo fue un calambre, todo está normal, te daré una pomada", nombre));
				}
			}
			
		}
	}
		 
	public static void Pecho(String nombre) {
		String respuesta = "";
		System.out.println(String.format("\nHola %s, mencionaste que tienes un dolos en el pecho", nombre));
		respuesta = pregunta(String.format("%s, ¿Es usted fumador? [Y/N]", nombre));
		while (!respuesta.equals("Y") && !respuesta.equals("N")) {
			respuesta = pregunta(String.format("\n%s, ¿Es usted fumador? [Y/N]", nombre));
		} if (respuesta.equals("Y")) {
			System.out.println(String.format("\nYa veo %s, te mandaré a hacer estudios del pulmon", nombre));
		} else if (respuesta.equals("N")) {
			respuesta = pregunta(String.format("\n%s, ¿Le duele la espalda? [Y/N]"));
			while (!respuesta.equals("Y") && !respuesta.equals("N")) {
				respuesta = pregunta(String.format("\n%s, ¿Le duele la espalda? [Y/N]"));
			} if (respuesta.equals("Y")) {
				System.out.println(String.format("\nOkey %s, lo mandaré con el ortopedista", nombre));
			} else if (respuesta.equals("N"));{
				System.out.println(String.format("\n%s, usted no tiene nada, solo fue un golpecillo", nombre));
			}
		}
	}
	
	public static void Estomago(String nombre) {
		String respuesta = "";
		System.out.println(String.format("Hola %s", nombre));
		respuesta = pregunta(String.format("%s ¿Tiene usted dolor abdominal? [Y/N]", nombre));
		while (!respuesta.equals("Y") && !respuesta.equals("N")) {
			respuesta = pregunta(String.format("%s ¿Tiene usted dolor abdominal? [Y/N]", nombre));
		} if (respuesta.equals("N")) {
			System.out.println(String.format("Usted %s solo tiene un dolor leve, tome esta pastilla", nombre));
		} else if (respuesta.equals("Y")) {
			respuesta = pregunta(String.format("%s ¿Tiene usted diarrea? [Y/N]", nombre));
			while (!respuesta.equals("Y") && !respuesta.equals("Y")) {
				respuesta = pregunta(String.format("%s ¿Tiene usted diarrea? [Y/N]", nombre));
			} if (respuesta.equals("Y")) {
				System.out.println(String.format("Aqui esta la respuesta %s, ", nombre));
			} else if (respuesta.equals("N")) {
				System.out.println(String.format("Creo que solo fue un retortijon %s, ", nombre));
			}
		}
	}
	
	public static void triaje(String nombre) {
		String respuesta = "";
		
		System.out.println(String.format("Hola %s", nombre));
		respuesta = pregunta(String.format("%s, ¿Has sufrido alguna caida? [Y/N]", nombre));
		while (!respuesta.equals("Y") && !respuesta.equals("N")){
			respuesta = pregunta(String.format("%s, ¿Has sufrido alguna caida? [Y/N]", nombre));
		} if (respuesta.equals("Y")) {
			Golpes(nombre);
		} else if (respuesta.equals("N")){
			respuesta = pregunta(String.format("%s, ¿Le duele el pecho? [Y/N]", nombre));
			while (!respuesta.equals("Y") && !respuesta.equals("N")) {
				respuesta = pregunta(String.format("%s, ¿Le duele el pecho? [Y/N]", nombre));
			} if(respuesta.equals("Y")) {
				Pecho(nombre);
			} else if (respuesta.equals("N")){
				respuesta = pregunta(String.format("%s, ¿Le duele el estomago? [Y/N]", nombre));;
				while((!respuesta.equals("Y") && !respuesta.equals("N"))){
					respuesta = pregunta(String.format("¿Le duele el estomago? [Y/N]", nombre));
				} if (respuesta.equals("Y")) {
					Estomago(nombre);	
				} else if(respuesta.equals("N")){
					System.out.println(String.format("Estimado %s usted esta mas sano que una lechuga", nombre));
				}
				
			}
		}		
	}
	
	public static void main(String[] args) {
		triaje("Juan");
	}
}

