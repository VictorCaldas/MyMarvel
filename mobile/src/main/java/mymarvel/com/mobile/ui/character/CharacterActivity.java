

package mymarvel.com.mobile.ui.character;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.mymarvel.core.data.model.CharacterMarvel;
import com.mymarvel.mobile.R;

import mymarvel.com.mobile.ui.base.BaseActivity;


public class CharacterActivity extends BaseActivity {

    private static final String EXTRA_CHARACTER_MARVEL = "characterMarvel";

    public static Intent newStartIntent(Context context, CharacterMarvel characterMarvel) {
        Intent intent = new Intent(context, CharacterActivity.class);
        intent.putExtra(EXTRA_CHARACTER_MARVEL, characterMarvel);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharacterMarvel characterMarvel = getIntent().getParcelableExtra(EXTRA_CHARACTER_MARVEL);
        if (characterMarvel == null) {
            throw new IllegalArgumentException("CharacterActivity requires a characterMarvel instance!");
        }

        setContentView(R.layout.activity_character);
        supportPostponeEnterTransition();
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.character_container, CharacterFragment.newInstance(characterMarvel))
                    .commit();
        }
    }
}
