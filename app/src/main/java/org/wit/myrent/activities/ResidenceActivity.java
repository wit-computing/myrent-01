package org.wit.myrent.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import org.wit.myrent.R;
import org.wit.myrent.models.Residence;

public class ResidenceActivity extends AppCompatActivity implements TextWatcher, CompoundButton.OnCheckedChangeListener
{
  private EditText geolocation;
  private Residence residence;

  private CheckBox rented;
  private Button dateButton;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_myrent);

    geolocation = (EditText) findViewById(R.id.geolocation);
    residence = new Residence();

    // Register a TextWatcher in the EditText geolocation object
    geolocation.addTextChangedListener(this);

    dateButton  = (Button)   findViewById(R.id.registration_date);
    rented      = (CheckBox) findViewById(R.id.isrented);

    dateButton .setEnabled(false);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.myrent, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item)
  {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings)
    {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @Override
  public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
  {

  }

  @Override
  public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
  {

  }

  @Override
  public void afterTextChanged(Editable editable)
  {
    residence.setGeolocation(editable.toString());
  }

  @Override
  public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
  {
    Log.i(this.getClass().getSimpleName(), "rented Checked");
    residence.rented = isChecked;
  }
}
