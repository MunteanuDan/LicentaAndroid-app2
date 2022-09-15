package eu.ase.ownerapp2.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseService {

    public static final String COMENZI_REFERENCE = "comenzi1";
    public static final String COMENZI_REFERENCE_SUMA = "comenziSuma";
    public static DatabaseReference referenceComenziMasa1Xanadu, referenceComenziMasa2Xanadu, referenceComenziMasa3Xanadu;
    public static DatabaseReference referenceComenziMasa1Klandestin, referenceComenziMasa2Klandestin, referenceComenziMasa3Klandestin;
    public static DatabaseReference referenceComenziMasa1SumaXanadu, referenceComenziMasa2SumaXanadu, referenceComenziMasa3SumaXanadu;
    public static DatabaseReference referenceComenziMasa1SumaKlandestin, referenceComenziMasa2SumaKlandestin, referenceComenziMasa3SumaKlandestin;
    private static FirebaseService firebaseService;

    private FirebaseService() {
        referenceComenziMasa1Xanadu = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE).child("Xanadu").child("1");
        referenceComenziMasa2Xanadu = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE).child("Xanadu").child("2");
        referenceComenziMasa3Xanadu = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE).child("Xanadu").child("3");
        referenceComenziMasa1Klandestin = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE).child("Klandestin").child("1");
        referenceComenziMasa2Klandestin = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE).child("Klandestin").child("2");
        referenceComenziMasa3Klandestin = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE).child("Klandestin").child("3");
        referenceComenziMasa1SumaXanadu = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE_SUMA).child("Xanadu").child("1");
        referenceComenziMasa2SumaXanadu = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE_SUMA).child("Xanadu").child("2");
        referenceComenziMasa3SumaXanadu = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE_SUMA).child("Xanadu").child("3");
        referenceComenziMasa1SumaKlandestin = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE_SUMA).child("Klandestin").child("1");
        referenceComenziMasa2SumaKlandestin = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE_SUMA).child("Klandestin").child("2");
        referenceComenziMasa3SumaKlandestin = FirebaseDatabase.getInstance().getReference(COMENZI_REFERENCE_SUMA).child("Klandestin").child("3");

    }

    public static FirebaseService getInstance() {
        if (firebaseService == null) {
            synchronized (FirebaseService.class) {
                if (firebaseService == null) {
                    firebaseService = new FirebaseService();
                }
            }
        }
        return firebaseService;
    }

}
