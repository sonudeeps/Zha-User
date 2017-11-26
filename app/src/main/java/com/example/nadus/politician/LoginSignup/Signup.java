package com.example.nadus.politician.LoginSignup;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nadus.politician.Adapters.SignUpAdapter;
import com.example.nadus.politician.Home.SampleActivity;
import com.example.nadus.politician.Home.menu.DrawerAdapter;
import com.example.nadus.politician.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Signup extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Calligrapher calligrapher;
    EditText input_name,input_password,input_dob,input_mail,input_profession,input_phone;
    TextView input_MP,input_MLA;
    Button button_signup;
    TextView already_account;
    Spinner s1,s2;
    TextInputLayout input_layout_name,input_layout_password,input_layout_mail,input_layout_MP,input_layout_MLA,input_layout_profession,input_layout_dob,input_layout_phone;

    FirebaseAuth firebaseAuth;

    private String email;
    private String password;
    private String name;
    private String phone;
    private String dob;
    private String MP;
    private String profession;
    private String MLA;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        calligrapher = new Calligrapher(this);
        calligrapher.setFont(Signup.this,"Ubuntu_R.ttf",true);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);


        already_account = (TextView) findViewById(R.id.textView3);
        input_name = (EditText) findViewById(R.id.input_name);
        input_dob = (EditText) findViewById(R.id.input_dob);
        input_MP = (TextView) findViewById(R.id.input_MP);
        input_password = (EditText) findViewById(R.id.input_password);
        input_mail = (EditText) findViewById(R.id.input_mail);
        input_MLA = (TextView) findViewById(R.id.input_MLA);
        input_profession = (EditText) findViewById(R.id.input_profession);
        input_phone = (EditText) findViewById(R.id.input_phone);
        button_signup = (Button) findViewById(R.id.button_signup);

        input_layout_name = (TextInputLayout) findViewById(R.id.input_layout_name);
        input_layout_mail = (TextInputLayout) findViewById(R.id.input_layout_mail);
        input_layout_password = (TextInputLayout) findViewById(R.id.input_layout_password);
        input_layout_phone = (TextInputLayout) findViewById(R.id.input_layout_phone);
        input_layout_MP = (TextInputLayout) findViewById(R.id.input_layout_MP);
        input_layout_MLA = (TextInputLayout) findViewById(R.id.input_layout_MLA);
        input_layout_profession = (TextInputLayout) findViewById(R.id.input_layout_profession);
        input_layout_dob = (TextInputLayout) findViewById(R.id.input_layout_dob);
        s1 = (Spinner)findViewById(R.id.spinner1);
        s2 = (Spinner)findViewById(R.id.spinner2);
        s1.setOnItemSelectedListener(this);

        input_name.addTextChangedListener(new MyTextWatcher(input_name));
        input_mail.addTextChangedListener(new MyTextWatcher(input_mail));
        input_password.addTextChangedListener(new MyTextWatcher(input_password));
        input_dob.addTextChangedListener(new MyTextWatcher(input_dob));
        input_phone.addTextChangedListener(new MyTextWatcher(input_phone));
        input_MP.addTextChangedListener(new MyTextWatcher(input_MP));
        input_profession.addTextChangedListener(new MyTextWatcher(input_profession));
        input_MLA.addTextChangedListener(new MyTextWatcher(input_MLA));

        input_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickdob();
            }
        });

        already_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this,Login.class));
                finish();
            }
        });

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

    }
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        String sp1= String.valueOf(s1.getSelectedItem());
        if(sp1.contentEquals("THIRUVALLUR")) {
            List<String> list = new ArrayList<String>();
            list.add("Gummidipoondi");
            list.add("Ponneri");
            list.add("Tiruttani");
            list.add("Thiruvallur");
            list.add("Poonamallee");
            list.add("Avadi");
            list.add("Ambattur");
            list.add("Madavaram");
            list.add("Maduravoyal");
            list.add("Tiruvottiyur");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("CHENNAI")) {
            List<String> list = new ArrayList<String>();
            list.add("DrRadhakrishnan Nagar");
            list.add("Perambur");
            list.add("Kolathur");
            list.add("Villivakkam");
            list.add("Thiru -Vi -Ka -Nagar");
            list.add("Egmore");
            list.add("Royapuram");
            list.add("Harbour");
            list.add("Chepauk-Thiruvallikeni");
            list.add("Thousand Lights");
            list.add("Anna Nagar");
            list.add("Virugampakkam");
            list.add("Saidapet");
            list.add("Thiyagarayanagar");
            list.add("Mylapore");
            list.add("Velachery");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }
        if(sp1.contentEquals("KANCHEEPURAM")) {
            List<String> list = new ArrayList<String>();
            list.add("Sholinganallur");
            list.add("Alandur");
            list.add("Sriperumbudur");
            list.add("Pallavaram");
            list.add("Tambaram");
            list.add("Chengalpattu");
            list.add("Thiruporur");
            list.add("Cheyyur");
            list.add("Madurantakam");
            list.add("Uthiramerur");
            list.add("Kancheepuram");
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            s2.setAdapter(dataAdapter3);
        }
        if(sp1.contentEquals("VELLORE")) {
            List<String> list = new ArrayList<String>();
            list.add("Arakkonam");
            list.add("Sholingur");
            list.add("Katpadi");
            list.add("Ranipet");
            list.add("Arcot");
            list.add("Vellore");
            list.add("Anaikattu");
            list.add("Kilvaithinankuppam");
            list.add("Gudiyattam");
            list.add("Vaniyambadi");
            list.add("Ambur");
            list.add("Jolarpet");
            list.add("Tiruppattur");
            ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter4.notifyDataSetChanged();
            s2.setAdapter(dataAdapter4);
        }
        if(sp1.contentEquals("KRISHNAGIRI")) {
            List<String> list = new ArrayList<String>();
            list.add("Uthangarai");
            list.add("Bargur");
            list.add("Krishnagiri");
            list.add("Veppanahalli");
            list.add("Hosur");
            list.add("Thalli");
            ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter5.notifyDataSetChanged();
            s2.setAdapter(dataAdapter5);
        }
        if(sp1.contentEquals("DHARMAPURI")) {
            List<String> list = new ArrayList<String>();
            list.add("Palacodu");
            list.add("Pennagaram");
            list.add("Dharmapuri");
            list.add("Pappireddippatti");
            list.add("Harur");
            ArrayAdapter<String> dataAdapter6 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter6.notifyDataSetChanged();
            s2.setAdapter(dataAdapter6);
        }
        if(sp1.contentEquals("TIRUVANNAMALAI")) {
            List<String> list = new ArrayList<String>();
            list.add("Chengam");
            list.add("Tiruvannamalai");
            list.add("Kilpennathur");
            list.add("Kalasapakkam");
            list.add("Polur");
            list.add("Arani");
            list.add("Cheyyar");
            list.add("Vandavasi");
            ArrayAdapter<String> dataAdapter7 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter7.notifyDataSetChanged();
            s2.setAdapter(dataAdapter7);
        }
        if(sp1.contentEquals("VILLUPURAM")) {
            List<String> list = new ArrayList<String>();
            list.add("Gingee");
            list.add("Mailam");
            list.add("Tindivanam");
            list.add("Vanur");
            list.add("Viluppuram");
            list.add("Vikravandi");
            list.add("Thirukoilur");
            list.add("Ulundurpettai");
            list.add("Rishivandiyam");
            list.add("Sankarapuram");
            list.add("Kallakurichi");
            ArrayAdapter<String> dataAdapter8 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter8.notifyDataSetChanged();
            s2.setAdapter(dataAdapter8);
        }
        if(sp1.contentEquals("SALEM")) {
            List<String> list = new ArrayList<String>();
            list.add("Gangavalli");
            list.add("Attur ");
            list.add("Yercaud");
            list.add("Omalur");
            list.add("Mettur");
            list.add("Edappadi");
            list.add("Sankari");
            list.add("Salem (West)");
            list.add("Salem (North)");
            list.add("Salem (South) ");
            ArrayAdapter<String> dataAdapter9 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter9.notifyDataSetChanged();
            s2.setAdapter(dataAdapter9);
        }
        if(sp1.contentEquals("NAMAKKAL")) {
            List<String> list = new ArrayList<String>();
            list.add("Rasipuram");
            list.add("Senthamangalam");
            list.add(" Namakkal");
            list.add("Paramathi-Velur");
            list.add("Tiruchengodu");
            list.add("Kumarapalayam");
            ArrayAdapter<String> dataAdapter10 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter10.notifyDataSetChanged();
            s2.setAdapter(dataAdapter10);
        }
        if(sp1.contentEquals("ERODE")) {
            List<String> list = new ArrayList<String>();
            list.add("Erode (East)");
            list.add("Erode (West)");
            list.add("Modakurichi");
            list.add("Dharapuram");
            list.add("Kangayam");
            list.add("Perundurai");
            list.add("Bhavani");
            list.add("Anthiyur");
            list.add("Gobichettipalayam");
            list.add("Bhavanisagar");

            ArrayAdapter<String> dataAdapter11 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter11.notifyDataSetChanged();
            s2.setAdapter(dataAdapter11);
        }
        if(sp1.contentEquals("THE NILGIRIS")) {
            List<String> list = new ArrayList<String>();
            list.add("Udhagamandalam");
            list.add("Gudalur");
            list.add("Coonoor");
            ArrayAdapter<String> dataAdapter12 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter12.notifyDataSetChanged();
            s2.setAdapter(dataAdapter12);
        }
        if(sp1.contentEquals("COIMBATORE")) {
            List<String> list = new ArrayList<String>();
            list.add("Mettuppalayam");
            list.add("Avanashi");
            list.add("Tiruppur (North)");
            list.add("Tiruppur (South)");
            list.add("Palladam");
            list.add("Sulur");
            list.add("Kavundampalayam");
            list.add("Coimbatore (North)");
            list.add("Thondamuthur");
            list.add("Coimbatore (South)");
            list.add("Singanallur");
            list.add("Kinathukadavu");
            list.add("Pollachi");
            list.add("Valparai");
            list.add("Udumalaipettai");
            list.add("Madathukulam");
            ArrayAdapter<String> dataAdapter13 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter13.notifyDataSetChanged();
            s2.setAdapter(dataAdapter13);
        }
        if(sp1.contentEquals("DINDIGUL")) {
            List<String> list = new ArrayList<String>();
            list.add("Palani");
            list.add("Oddanchatram");
            list.add("Athoor");
            list.add("Nilakkottai");
            list.add("Natham");
            list.add("Dindigul");
            list.add("Vedasandur");
            ArrayAdapter<String> dataAdapter14 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter14.notifyDataSetChanged();
            s2.setAdapter(dataAdapter14);
        }
        if(sp1.contentEquals("KARUR")) {
            List<String> list = new ArrayList<String>();
            list.add("Aravakurichi");
            list.add("Karur");
            list.add("Krishnarayapuram");
            list.add("Kulithalai");
            ArrayAdapter<String> dataAdapter14 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter14.notifyDataSetChanged();
            s2.setAdapter(dataAdapter14);
        }
        if(sp1.contentEquals("TIRUCHIRAPPALLI")) {
            List<String> list = new ArrayList<String>();
            list.add("Manapparai");
            list.add("Srirangam");
            list.add("Tiruchirappalli (West)");
            list.add("Tiruchirappalli (East)");
            list.add("Thiruverumbur");
            list.add("Lalgudi");
            list.add("Manachanallur");
            list.add("Musiri");
            list.add("Thuraiyur");
            ArrayAdapter<String> dataAdapter15 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter15.notifyDataSetChanged();
            s2.setAdapter(dataAdapter15);
        }
        if(sp1.contentEquals("PERAMBALUR")) {
            List<String> list = new ArrayList<String>();
            list.add("Perambalur ");
            list.add("Kunnam");
            list.add("Ariyalur");
            list.add("Jayankondam");
            ArrayAdapter<String> dataAdapter16 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter16.notifyDataSetChanged();
            s2.setAdapter(dataAdapter16);
        }
        if(sp1.contentEquals("CUDDALORE")) {
            List<String> list = new ArrayList<String>();
            list.add("Tittakudi");
            list.add("Vriddhachalam");
            list.add("Neyveli");
            list.add("Panruti");
            list.add("Cuddalore");
            list.add("Kurinjipadi");
            list.add("Bhuvanagiri");
            list.add("Chidambaram");
            list.add("Kattumannarkoil ");
            ArrayAdapter<String> dataAdapter17 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter17.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter17.notifyDataSetChanged();
            s2.setAdapter(dataAdapter17);
        }
        if(sp1.contentEquals("NAGAPATTINAM")) {
            List<String> list = new ArrayList<String>();
            list.add("Sirkazhi ");
            list.add("Mayiladuthurai");
            list.add("Poompuhar");
            list.add("Nagapattinam");
            list.add("Kilvelur ");
            list.add("Vedaranyam");
            ArrayAdapter<String> dataAdapter18 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter18.notifyDataSetChanged();
            s2.setAdapter(dataAdapter18);
        }
        if(sp1.contentEquals("THIRUVARUR")) {
            List<String> list = new ArrayList<String>();
            list.add("Thiruthuraipoondi");
            list.add("Mannargudi");
            list.add("Thiruvarur");
            list.add("Nannilam");
            ArrayAdapter<String> dataAdapter19 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter19.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter19.notifyDataSetChanged();
            s2.setAdapter(dataAdapter19);
        }
        if(sp1.contentEquals("THANJAVUR")) {
            List<String> list = new ArrayList<String>();
            list.add("Thiruvidaimarudur");
            list.add("Kumbakonam");
            list.add("Papanasam");
            list.add("Thiruvaiyaru");
            list.add("Thanjavur");
            list.add("Orattanadu");
            list.add("Pattukkottai");
            list.add("Peravurani");
            ArrayAdapter<String> dataAdapter20 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter20.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter20.notifyDataSetChanged();
            s2.setAdapter(dataAdapter20);
        }
        if(sp1.contentEquals("PUDUKKOTTAI")) {
            List<String> list = new ArrayList<String>();
            list.add("Gandarvakottai ");
            list.add("Viralimalai");
            list.add("Pudukkottai");
            list.add("Thirumayam");
            list.add("Aranthangi");
            list.add("Alangudi");
            ArrayAdapter<String> dataAdapter21 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter21.notifyDataSetChanged();
            s2.setAdapter(dataAdapter21);
        }
        if(sp1.contentEquals("SIVAGANGA")) {
            List<String> list = new ArrayList<String>();
            list.add("Karaikudi");
            list.add("Tiruppattur");
            list.add("Sivaganga");
            list.add("Manamadurai ");
            ArrayAdapter<String> dataAdapter22 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter22.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter22.notifyDataSetChanged();
            s2.setAdapter(dataAdapter22);
        }
        if(sp1.contentEquals("MADURAI")) {
            List<String> list = new ArrayList<String>();
            list.add("Melur");
            list.add("Madurai East");
            list.add("Sholavandan");
            list.add("Madurai North");
            list.add("Madurai South");
            list.add("Madurai Wast");
            list.add("Madurai Central");
            list.add("Thiruparankundram");
            list.add("Thirumangalam");
            list.add("Usilampatti");
            ArrayAdapter<String> dataAdapter23 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter23.notifyDataSetChanged();
            s2.setAdapter(dataAdapter23);
        }
        if(sp1.contentEquals("THENI")) {
            List<String> list = new ArrayList<String>();
            list.add("Andipatti");
            list.add("Periyakulam");
            list.add("Bodinayackanur");
            list.add("Cumbum");
            ArrayAdapter<String> dataAdapter24 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter24.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter24.notifyDataSetChanged();
            s2.setAdapter(dataAdapter24);
        }
        if(sp1.contentEquals("VIRUDHUNAGAR")) {
            List<String> list = new ArrayList<String>();
            list.add("Rajapalayam");
            list.add("Srivilliputhur");
            list.add("Sattur");
            list.add("Sivakasi");
            list.add("Virudhunagar");
            list.add("Aruppukkottai");
            list.add("Tiruchuli");
            ArrayAdapter<String> dataAdapter25 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter25.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter25.notifyDataSetChanged();
            s2.setAdapter(dataAdapter25);
        }
        if(sp1.contentEquals("RAMANATHAPURAM")) {
            List<String> list = new ArrayList<String>();
            list.add("Paramakudi");
            list.add("Tiruvadanai");
            list.add("Ramanathapuram");
            list.add("Mudhukulathur");
            ArrayAdapter<String> dataAdapter26 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter26.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter26.notifyDataSetChanged();
            s2.setAdapter(dataAdapter26);
        }
        if(sp1.contentEquals("THOOTHUKKUDI")) {
            List<String> list = new ArrayList<String>();
            list.add("Vilathikulam");
            list.add("Thoothukkudi");
            list.add("Tiruchendur");
            list.add("Srivaikuntam");
            list.add("Ottapidaram ");
            list.add("Kovilpatti");
            ArrayAdapter<String> dataAdapter27 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter27.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter27.notifyDataSetChanged();
            s2.setAdapter(dataAdapter27);
        }
        if(sp1.contentEquals("TIRUNELVELI")) {
            List<String> list = new ArrayList<String>();
            list.add("Sankarankovil");
            list.add("Vasudevanallur");
            list.add("Kadayanallur");
            list.add("Tenkasi");
            list.add("Alangulam");
            list.add("Tirunelveli");
            list.add("Ambasamudram");
            list.add("Palayamkottai");
            list.add("Nanguneri");
            list.add("Radhapuram");
            ArrayAdapter<String> dataAdapter28 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter28.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter28.notifyDataSetChanged();
            s2.setAdapter(dataAdapter28);
        }
        if(sp1.contentEquals("KANNIYAKUMARI")) {
            List<String> list = new ArrayList<String>();
            list.add("Kanniyakumari");
            list.add("Nagercoil");
            list.add("Colachel");
            list.add("Padmanabhapuram");
            list.add("Vilavancode");
            list.add("Killiyoor");
            ArrayAdapter<String> dataAdapter29 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter29.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter29.notifyDataSetChanged();
            s2.setAdapter(dataAdapter29);
        }
        if(sp1.contentEquals("திருவள்ளூர்")) {
            List<String> list = new ArrayList<String>();
            list.add("கும்மிடிப்பூண்டி");
            list.add("பொன்னேரி");
            list.add("திருத்தணி");
            list.add("திருவள்ளூர்");
            list.add("பூந்தமல்லி");
            list.add("ஆவடி");
            list.add("மதுரவாயல்");
            list.add("அம்பத்தூர்");
            list.add("மாதவரம்");
            list.add("திருவொற்றியூர்");
            ArrayAdapter<String> dataAdapter1a = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter1a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter1a.notifyDataSetChanged();
            s2.setAdapter(dataAdapter1a);
        }
        if(sp1.contentEquals("சென்னை")) {
            List<String> list = new ArrayList<String>();
            list.add("ராதாகிருஷ்ணன்நகர்");
            list.add("பெரம்பூர்");
            list.add("வில்லிவாக்கம்");
            list.add("திருவிகநகர்");
            list.add("எழும்பூர்");
            list.add("இராயபுரம்");
            list.add("துறைமுகம்");
            list.add("சேப்பாக்கம்");
            list.add("ஆயிரம்விளக்கு");
            list.add("அண்ணாநகர்");
            list.add("விருகம்பாக்கம்");
            list.add("சைதாப்பேட்டை");
            list.add("சதியாகராயநகர்");
            list.add("மயிலாப்பூர்");
            list.add("வேளச்சேரி");
            ArrayAdapter<String> dataAdapter2a = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2a.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2a);
        }
        if(sp1.contentEquals("காஞ்சிபுரம்")) {
            List<String> list = new ArrayList<String>();
            list.add("சோழிங்கநல்லூர்");
            list.add("ஆலந்தூர்");
            list.add("திருப்பெரும்புதூர்");
            list.add("பல்லாவரம்");
            list.add("தாம்பரம்");
            list.add("செங்கல்பட்டு");
            list.add("திருப்போரூர்");
            list.add("செய்யூர்");
            list.add("மதுராந்தகம்");
            list.add("உத்திரமேரூர்");
            list.add("காஞ்சிபுரம்");
            ArrayAdapter<String> dataAdapter3a = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter3a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3a.notifyDataSetChanged();
            s2.setAdapter(dataAdapter3a);
        }
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    private void pickdob() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                input_dob.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    private void validate() {
        if (!validateName()) {
            return;
        }

        if (!validateMail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        if (!validateDOB()) {
            return;
        }

        if (!validatePhone()) {
            return;
        }

//        if (!validateLocation()) {
//            return;
//        }

        if (!validateProfession()) {
            return;
        }

//        if (!validatePost()) {
//            return;
//        }

        validateComplete();
    }

    private void validateComplete() {

        email = input_mail.getText().toString().trim();
        password = input_password.getText().toString().trim();
        System.out.println("test ---> Entering validate");
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    System.out.println("test ---> Calling upload");
                    uploadFirebaseData();
                }
                else
                {
                    Toast.makeText(Signup.this,"Registration Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void uploadFirebaseData() {
        name = input_name.getText().toString().trim();
        phone = input_phone.getText().toString().trim();
        dob = input_dob.getText().toString().trim();
      //  location = input_location.getText().toString().trim();
        profession = input_profession.getText().toString().trim();
      //  post = input_post.getText().toString().trim();

       // System.out.println("test ---> "+name+phone+dob+location+profession+post);
        FirebaseUser user = firebaseAuth.getCurrentUser();

        SignUpAdapter signUpAdapter = new SignUpAdapter();
        signUpAdapter.setName(name);
        signUpAdapter.setMail(email);
        signUpAdapter.setPassword(password);
        signUpAdapter.setPhone(phone);
      //  signUpAdapter.setLocation(location);
        signUpAdapter.setDob(dob);
        signUpAdapter.setProfession(profession);
       // signUpAdapter.setPost(post);

      //  databaseReference.child("Users").child(location).child(post).child(user.getUid()).setValue(signUpAdapter);

        this.finish();
        startActivity(new Intent(this,Login.class));
    }

    private boolean validateName() {
        if ((input_name.getText().toString().trim().isEmpty())||(input_name.getText().toString().length()<5)) {
            input_layout_name.setError(getString(R.string.err_msg_name));
            requestFocus(input_name);
            return false;
        } else {
            input_layout_name.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateMail() {
        String email = input_mail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            input_layout_mail.setError(getString(R.string.err_msg_mail));
            requestFocus(input_mail);
            return false;
        } else {
            input_layout_mail.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    private boolean validatePassword() {
        if ((input_password.getText().toString().trim().isEmpty())||(input_password.getText().toString().length()<8)) {
            input_layout_password.setError(getString(R.string.err_msg_password));
            requestFocus(input_password);
            return false;
        } else {
            input_layout_password.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateDOB() {
        if (input_dob.getText().toString().trim().isEmpty()) {
            input_layout_dob.setError(getString(R.string.err_msg_dob));
            requestFocus(input_dob);
            return false;
        } else {
            input_layout_dob.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhone() {
        if ((input_phone.getText().toString().trim().isEmpty())||(input_phone.getText().toString().length()!=10)) {
            input_layout_phone.setError(getString(R.string.err_msg_phone));
            requestFocus(input_phone);
            return false;
        } else {
            input_layout_phone.setErrorEnabled(false);
        }

        return true;
    }

//    private boolean validateLocation() {
//        if (input_location.getText().toString().trim().isEmpty()) {
//            input_layout_location.setError(getString(R.string.err_msg_location));
//            requestFocus(input_location);
//            return false;
//        } else {
//            input_layout_location.setErrorEnabled(false);
//        }
//
//        return true;
//    }

    private boolean validateProfession() {
        if (input_profession.getText().toString().trim().isEmpty()) {
            input_layout_profession.setError(getString(R.string.err_msg_profession));
            requestFocus(input_profession);
            return false;
        } else {
            input_layout_profession.setErrorEnabled(false);
        }

        return true;
    }

//    private boolean validatePost() {
//        if (input_post.getText().toString().trim().isEmpty()) {
//            input_layout_post.setError(getString(R.string.err_msg_post));
//            requestFocus(input_post);
//            return false;
//        } else {
//            input_layout_post.setErrorEnabled(false);
//        }
//
//        return true;
//    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_mail:
                    validateMail();
                    break;
                case R.id.input_password:
                    validatePassword();
                    break;
                case R.id.input_dob:
                    validateDOB();
                    break;
                case R.id.input_phone:
                    validatePhone();
                    break;
//                case R.id.input_location:
//                //    validateLocation();
//                    break;
                case R.id.input_profession:
                    validateProfession();
                    break;
//                case R.id.input_post:
//                //   validatePost();
//                    break;
            }
        }
    }
}
