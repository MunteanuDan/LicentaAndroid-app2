package eu.ase.ownerapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import eu.ase.ownerapp2.firebase.FirebaseService;

import static eu.ase.ownerapp2.firebase.FirebaseService.COMENZI_REFERENCE;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa1SumaXanadu;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa1Xanadu;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa2SumaXanadu;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa2Xanadu;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa3SumaXanadu;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa3Xanadu;

public class MainActivity extends AppCompatActivity {

    private ImageView ivXanadu, ivKlandestin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ivXanadu = findViewById(R.id.Xanadu_iv);
        ivKlandestin = findViewById(R.id.Klandestin_iv);

        ivXanadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OwnerXanadu.class);
                startActivity(intent);
            }
        });

        ivKlandestin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), OwnerKlandestin.class);
                startActivity(intent);
            }
        });


    }
}