public class Helper {

    public String gerarString(int tamanho) {
        String caracter = "";

        for (int i = 0; i <= tamanho; i++) {
            caracter += "M";
        }
        return caracter;
    }
}
