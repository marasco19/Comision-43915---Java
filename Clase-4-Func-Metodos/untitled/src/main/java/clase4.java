public class clase4 {
    public static void main(String[] args) {
        Valores primerValor = new Valores();
        int valor1 = primerValor.incrementar();
        System.out.println("Valor--->"+ valor1);
        public class Valores {
            public int getValor() {
                return valor;
            }

            public void setValor(int valor) {
                this.valor = valor;
            }

            private int valor;

            public void incrementar(){
                this.valor++;
            }
        }
    }
}
