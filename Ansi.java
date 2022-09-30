public class Ansi 
{
    /**
     * Enumerado de valores ANSI para configurar color de letra del texto a imprimir en terminal
     */
    public static enum ColorLetra
    {
        negro("\u001B[30m"),
        rojo("\u001B[31m"),
        verde("\u001B[32m"),
        amarillo("\u001B[33m"),
        azul("\u001B[34m"),
        magenta("\u001B[35m"),
        cyan("\u001B[36m"),
        blanco("\u001B[37m");

        private final String value;

        private ColorLetra(String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
    }
    
    /**
     * Enumerado de valores ANSI para configurar color de fondo del texto a imprimir en terminal
     */
    public static enum ColorFondo 
    {
        negro("\u001B[40m"),
        rojo("\u001B[41m"),
        verde("\u001B[42m"),
        amarillo("\u001B[43m"),
        azul("\u001B[44m"),
        magenta("\u001B[45m"),
        cyan("\u001B[46m"),
        blanco("\u001B[47m");

        private final String value;

        private ColorFondo(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Borra la terminal
     */
    public static void limpiarPantalla() 
    {  
        System.out.print("\033[H\033[2J");  
    }  
    /**
     * Reestablece las configuraciones de color del texto a imprimir
     */
    public static void restablecerColor() 
    {  
        System.out.print("\u001B[0m");  
    }  
    /**
     * Imprime en terminal un texto introducido
     * @param colorLetra (Enum ColorLetra) Color de la letra
     * @param colorFondo (Enum ColorLetra) Color de la letra
     * @param texto (String) texto a imprimir
     * @param restablecer (boolean) true: restablece las configuraciones de color de texto a su valor por defecto
     */
    public static void imprimir(ColorLetra colorLetra, ColorFondo colorFondo, String texto, boolean restablecer) 
    {  
        System.out.print(colorLetra.getValue());  
        System.out.print(colorFondo.getValue());  
        System.out.println(texto);  
        if (restablecer)
            restablecerColor();
    }  

    /**
     * Imprime en terminal un texto introducido y reestablece las configuraciones de color del texto luego de imprimir
     * @param colorLetra (Enum ColorLetra) Color de la letra
     * @param colorFondo (Enum ColorLetra) Color de la letra
     * @param texto (String) texto a imprimir
     */
    public static void imprimir(ColorLetra colorLetra, ColorFondo colorFondo, String texto) 
    {  
        System.out.print(colorLetra.getValue());  
        System.out.print(colorFondo.getValue());  
        System.out.println(texto);  
        restablecerColor();
    }  

    /**
     * Imprime en terminal un texto introducido y reestablece las configuraciones de color del texto luego de imprimir
     * @param colorLetra (Enum ColorLetra) Color de la letra
     * @param texto (String) texto a imprimir
     */
    public static void imprimir(ColorFondo colorFondo, String texto) 
    {  
        System.out.print(colorFondo.getValue());  
        System.out.println(texto);  
        restablecerColor();

    }  

    /**
     * Imprime en terminal un texto introducido y reestablece las configuraciones de color del texto luego de imprimir
     * @param colorLetra (Enum ColorLetra) Color de la letra
     * @param texto (String) texto a imprimir
     */
    public static void imprimir(ColorLetra colorLetra, String texto) 
    {  
        System.out.print(colorLetra.getValue());  
        System.out.println(texto);  
        restablecerColor();

    }  

}
