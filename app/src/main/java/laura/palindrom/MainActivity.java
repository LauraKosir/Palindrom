package laura.palindrom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView string;
    TextView header;
    Button checkString;
    EditText inputString;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkString = (Button) findViewById(R.id.checkString);
        header = (TextView) findViewById(R.id.header);
        string = (TextView) findViewById(R.id.string) ;
        inputString = (EditText) findViewById(R.id.inputString);
        result = (TextView) findViewById (R.id.result);


        checkString.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String str = inputString.getText().toString();
                StringBuilder b = new StringBuilder(str);

                //Prüft eingegebenen String auf Palindrome
                if (str.length()>=5 && str.equals(new StringBuilder(str).reverse().toString())) {
                    result.setText("Ergebnis: Palindrom");
                } else {
                    result.setText("Ergebnis: kein Palindrom");

                }

                //prüft ob die Eingabe kleiner ist als 5 Zeichen
                if(str.length()<5) {
                    result.setText("Achtung: Das Wort muss min. 5 Zeichen lang sein");
                }

                //prüft ob der eingegebene String Sonderzeichen oder Zahlen beinhaltet
                if (str.contains("!") || str.contains("/") || str.contains("_") || str.contains("?") || str.contains("€") || str.contains("0")|| str.contains("1")||
                        str.contains("2")|| str.contains("3")|| str.contains("4")|| str.contains("5")|| str.contains("6")|| str.contains("7")|| str.contains("8")|| str.contains("9")){
                    result.setText("Fehler: Nur Buchstaben erlaubt");
                }

            }
        } );
    }


}
