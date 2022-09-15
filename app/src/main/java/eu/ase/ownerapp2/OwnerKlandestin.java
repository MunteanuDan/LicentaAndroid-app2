package eu.ase.ownerapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import eu.ase.ownerapp2.firebase.FirebaseService;

import static eu.ase.ownerapp2.firebase.FirebaseService.COMENZI_REFERENCE;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa1SumaKlandestin;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa1Klandestin;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa2SumaKlandestin;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa2Klandestin;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa3SumaKlandestin;
import static eu.ase.ownerapp2.firebase.FirebaseService.referenceComenziMasa3Klandestin;

public class OwnerKlandestin extends AppCompatActivity {

    private DatabaseReference mRootRef1;
    private FirebaseService firebaseService;
    private AnimationDrawable anim, anim2, anim3;
    private Button btn_masa_1, btn_masa_2, btn_masa_3;
    private Button btn_masa_1_finalizare, btn_masa_2_finalizare, btn_masa_3_finalizare;
    private TextView tv_masa_1_suma, tv_masa_2_suma, tv_masa_3_suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_klandestin);

        firebaseService = FirebaseService.getInstance();
        initComponents();
        mRootRef1 = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE).child("1");

        referenceComenziMasa1Klandestin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("true")) {
                    btn_masa_1.setBackgroundColor(0xFFC62828);
                    btn_masa_1.setText(R.string.finalizata);
                    Toast.makeText(getApplicationContext(), "rosu", Toast.LENGTH_SHORT).show();
                } else if ((dataSnapshot.getValue().toString().equals("false"))) {
                    btn_masa_1.setBackgroundColor(0xFF00B0FF);
                    btn_masa_1.setText(R.string.start);
                    tv_masa_1_suma.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "albastru", Toast.LENGTH_SHORT).show();
                } else {
                    btn_masa_1.setBackgroundColor(0xFF76FF03);
                    btn_masa_1.setText(R.string.in_curs);
                    tv_masa_1_suma.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "verde", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        referenceComenziMasa1SumaKlandestin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    tv_masa_1_suma.setText(dataSnapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        referenceComenziMasa2Klandestin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("true")) {
                    btn_masa_2.setBackgroundColor(0xFFC62828);
                    btn_masa_2.setText(R.string.finalizata);
                    Toast.makeText(getApplicationContext(), "rosu", Toast.LENGTH_SHORT).show();
                } else if ((dataSnapshot.getValue().toString().equals("false"))) {
                    btn_masa_2.setBackgroundColor(0xFF00B0FF);
                    btn_masa_2.setText(R.string.start);
                    tv_masa_2_suma.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "albastru", Toast.LENGTH_SHORT).show();
                } else {
                    btn_masa_2.setBackgroundColor(0xFF76FF03);
                    btn_masa_2.setText(R.string.in_curs);
                    tv_masa_2_suma.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "verde", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceComenziMasa2SumaKlandestin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    tv_masa_2_suma.setText(dataSnapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        referenceComenziMasa3Klandestin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue().toString().equals("true")) {
                    btn_masa_3.setBackgroundColor(0xFFC62828);
                    btn_masa_3.setText(R.string.finalizata);
                } else if ((dataSnapshot.getValue().toString().equals("false"))) {
                    btn_masa_3.setBackgroundColor(0xFF00B0FF);
                    btn_masa_3.setText(R.string.start);
                    tv_masa_3_suma.setVisibility(View.INVISIBLE);
                } else {
                    btn_masa_3.setBackgroundColor(0xFF76FF03);
                    btn_masa_3.setText(R.string.in_curs);
                    tv_masa_3_suma.setVisibility(View.VISIBLE);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        referenceComenziMasa3SumaKlandestin.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    tv_masa_3_suma.setText(dataSnapshot.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        anim = (AnimationDrawable) btn_masa_1_finalizare.getBackground();
        anim.setEnterFadeDuration(2300);
        anim.setExitFadeDuration(2300);

        anim2 = (AnimationDrawable) btn_masa_2_finalizare.getBackground();
        anim2.setEnterFadeDuration(2800);
        anim2.setExitFadeDuration(2800);

        anim3 = (AnimationDrawable) btn_masa_3_finalizare.getBackground();
        anim3.setEnterFadeDuration(2700);
        anim3.setExitFadeDuration(2700);

    }


    private void initComponents() {

        btn_masa_1_finalizare = findViewById(R.id.btn_masa_1_finalizare);
        btn_masa_2_finalizare = findViewById(R.id.btn_masa_2_finalizare);
        btn_masa_3_finalizare = findViewById(R.id.btn_masa_3_finalizare);
        btn_masa_1 = findViewById(R.id.btn_masa_1);
        btn_masa_2 = findViewById(R.id.btn_masa_2);
        btn_masa_3 = findViewById(R.id.btn_masa_3);

        tv_masa_1_suma = findViewById(R.id.tv_masa_1_suma);
        tv_masa_2_suma = findViewById(R.id.tv_masa_2_suma);
        tv_masa_3_suma = findViewById(R.id.tv_masa_3_suma);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (anim != null && !anim.isRunning()) {
            anim.start();
        }

        if (anim2 != null && !anim2.isRunning()) {
            anim2.start();
        }

        if (anim3 != null && !anim3.isRunning()) {
            anim3.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (anim != null && anim.isRunning()) {
            anim.stop();
        }

        if (anim2 != null && anim2.isRunning()) {
            anim2.stop();
        }

        if (anim3 != null && anim3.isRunning()) {
            anim3.stop();
        }

    }


    public void btnMasa1Finalizare(View v) {
        AlertDialog.Builder build = new AlertDialog.Builder(OwnerKlandestin.this)
                .setTitle("Finalizare comanda")
                .setMessage("Sigur doriti finalizarea comenzii?")
                .setPositiveButton("Yes", (DialogInterface.OnClickListener)
                        getSaveComandaMasa1ClickEventPositiveEvent())
                .setNegativeButton("No", getSaveComandaMasa1ClickEventNegativeEvent());
        build.create().show();

    }

    private DialogInterface.OnClickListener getSaveComandaMasa1ClickEventPositiveEvent() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                referenceComenziMasa1Klandestin.setValue("false");
            }
        };
    }

    private DialogInterface.OnClickListener getSaveComandaMasa1ClickEventNegativeEvent() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ati renuntat la actiunea selectata",
                        Toast.LENGTH_SHORT).show();
            }
        };
    }


    public void btnMasa2Finalizare(View v) {
        AlertDialog.Builder build = new AlertDialog.Builder(OwnerKlandestin.this)
                .setTitle("Finalizare comanda")
                .setMessage("Sigur doriti finalizarea comenzii?")
                .setPositiveButton("Yes", (DialogInterface.OnClickListener)
                        getSaveComandaMasa2ClickEventPositiveEvent())
                .setNegativeButton("No", getSaveComandaMasa2ClickEventNegativeEvent());
        build.create().show();
    }

    private DialogInterface.OnClickListener getSaveComandaMasa2ClickEventPositiveEvent() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                referenceComenziMasa2Klandestin.setValue("false");
            }
        };
    }

    private DialogInterface.OnClickListener getSaveComandaMasa2ClickEventNegativeEvent() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ati renuntat la actiunea selectata",
                        Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void btnMasa3Finalizare(View v) {
        AlertDialog.Builder build = new AlertDialog.Builder(OwnerKlandestin.this)
                .setTitle("Finalizare comanda")
                .setMessage("Sigur doriti finalizarea comenzii?")
                .setPositiveButton("Yes", (DialogInterface.OnClickListener)
                        getSaveComandaMasa3ClickEventPositiveEvent())
                .setNegativeButton("No", getSaveComandaMasa3ClickEventNegativeEvent());
        build.create().show();
    }


    private DialogInterface.OnClickListener getSaveComandaMasa3ClickEventPositiveEvent() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                referenceComenziMasa3Klandestin.setValue("false");
            }
        };
    }


    private DialogInterface.OnClickListener getSaveComandaMasa3ClickEventNegativeEvent() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Ati renuntat la actiunea selectata",
                        Toast.LENGTH_SHORT).show();
            }
        };
    }

}