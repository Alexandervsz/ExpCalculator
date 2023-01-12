package com.example.expcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedHashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView textViewRequiredActions;
    TextView textViewActionsRequired;
    TextView textViewTimeRequired;
    TextView textViewTimeRequiredText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText textViewCurrentXp = findViewById(R.id.editTextCurrentXp);
        EditText textViewTargetLevel = findViewById(R.id.editTextTargetLevel);
        EditText textViewXpPerAction = findViewById(R.id.editTextXpPerAction);
        EditText textViewTimePerAction = findViewById(R.id.editTextTimePerAction);
        textViewRequiredActions = findViewById(R.id.textViewActionsRequired);
        textViewActionsRequired = findViewById(R.id.textViewRequiredActions);
        textViewTimeRequired = findViewById(R.id.textViewTimeRequired);
        textViewTimeRequiredText = findViewById(R.id.textViewTimeRequiredText);
        LinkedHashMap<Integer, Integer> expTable = new LinkedHashMap<>();
        expTable.put(2, 83);
        expTable.put(3, 174);
        expTable.put(4, 276);
        expTable.put(5, 388);
        expTable.put(6, 512);
        expTable.put(7, 650);
        expTable.put(8, 801);
        expTable.put(9, 969);
        expTable.put(10, 1154);
        expTable.put(11, 1358);
        expTable.put(12, 1584);
        expTable.put(13, 1833);
        expTable.put(14, 2107);
        expTable.put(15, 2411);
        expTable.put(16, 2746);
        expTable.put(17, 3115);
        expTable.put(18, 3523);
        expTable.put(19, 3973);
        expTable.put(20, 4470);
        expTable.put(21, 5018);
        expTable.put(22, 5624);
        expTable.put(23, 6291);
        expTable.put(24, 7028);
        expTable.put(25, 7842);
        expTable.put(26, 8740);
        expTable.put(27, 9730);
        expTable.put(28, 10824);
        expTable.put(29, 12031);
        expTable.put(30, 13363);
        expTable.put(31, 14833);
        expTable.put(32, 16456);
        expTable.put(33, 18247);
        expTable.put(34, 20224);
        expTable.put(35, 22406);
        expTable.put(36, 24815);
        expTable.put(37, 27473);
        expTable.put(38, 30408);
        expTable.put(39, 33648);
        expTable.put(40, 37224);
        expTable.put(41, 41171);
        expTable.put(42, 45529);
        expTable.put(43, 50339);
        expTable.put(44, 55649);
        expTable.put(45, 61512);
        expTable.put(46, 67983);
        expTable.put(47, 75127);
        expTable.put(48, 83014);
        expTable.put(49, 91721);
        expTable.put(50, 101333);
        expTable.put(51, 111945);
        expTable.put(52, 123660);
        expTable.put(53, 136594);
        expTable.put(54, 150872);
        expTable.put(55, 166636);
        expTable.put(56, 184040);
        expTable.put(57, 203254);
        expTable.put(58, 224466);
        expTable.put(59, 247886);
        expTable.put(60, 273742);
        expTable.put(61, 302288);
        expTable.put(62, 333804);
        expTable.put(63, 368599);
        expTable.put(64, 407015);
        expTable.put(65, 449428);
        expTable.put(66, 496254);
        expTable.put(67, 547953);
        expTable.put(68, 605032);
        expTable.put(69, 668051);
        expTable.put(70, 737627);
        expTable.put(71, 814445);
        expTable.put(72, 899257);
        expTable.put(73, 992895);
        expTable.put(74, 1096278);
        expTable.put(75, 1210421);
        expTable.put(76, 1336443);
        expTable.put(77, 1475581);
        expTable.put(78, 1629200);
        expTable.put(79, 1798808);
        expTable.put(80, 1986068);
        expTable.put(81, 2192818);
        expTable.put(82, 2421087);
        expTable.put(83, 2673114);
        expTable.put(84, 2951373);
        expTable.put(85, 3258594);
        expTable.put(86, 3597792);
        expTable.put(87, 3972294);
        expTable.put(88, 4385776);
        expTable.put(89, 4842295);
        expTable.put(90, 5346332);
        expTable.put(91, 5902831);
        expTable.put(92, 6517253);
        expTable.put(93, 7195629);
        expTable.put(94, 7944614);
        expTable.put(95, 8771558);
        expTable.put(96, 9684577);
        expTable.put(97, 10692629);
        expTable.put(98, 11805606);
        expTable.put(99, 13034431);
        expTable.put(100, 14391160);
        expTable.put(101, 15889109);
        expTable.put(102, 17542976);
        expTable.put(103, 19368992);
        expTable.put(104, 21385073);
        expTable.put(105, 23611006);
        expTable.put(106, 26068632);
        expTable.put(107, 28782069);
        expTable.put(108, 31777943);
        expTable.put(109, 35085654);
        expTable.put(110, 38737661);
        expTable.put(111, 42769801);
        expTable.put(112, 47221641);
        expTable.put(113, 52136869);
        expTable.put(114, 57563718);
        expTable.put(115, 63555443);
        expTable.put(116, 70170840);
        expTable.put(117, 77474828);
        expTable.put(118, 85539082);
        expTable.put(119, 94442737);
        expTable.put(120, 104273167);
        Button button = findViewById(R.id.buttonCalculate);
        button.setOnClickListener(view -> {
            if (textViewTargetLevel.getText().toString().equals("")) {
                SetError(this.getResources().getString(R.string.i_level));
                return;
            }
            int targetLevel = Integer.parseInt(String.valueOf(textViewTargetLevel.getText()));
            if (textViewCurrentXp.getText().toString().equals("")) {
                SetError(this.getResources().getString(R.string.i_xp));
                return;
            }
            int currentXp = Integer.parseInt(String.valueOf(textViewCurrentXp.getText()));

            if (textViewXpPerAction.getText().toString().equals("")) {
                SetError(this.getResources().getString(R.string.i_pa));
                return;
            }
            int xpPerAction = Integer.parseInt(String.valueOf(textViewXpPerAction.getText()));
            if (xpPerAction == 0) {
                SetError(this.getResources().getString(R.string.i_pa));
                return;
            }
            double timePerAction = 0.0;
            if (textViewTimePerAction.getText().toString().equals("")) {
                ClearTime();
            } else {
                timePerAction = Double.parseDouble(String.valueOf(textViewTimePerAction.getText()));
                if (timePerAction == 0) {
                    ClearTime();
                }
            }
            if (expTable.get(targetLevel) != null) {
                @SuppressWarnings("ConstantConditions") float requiredExperience = expTable.get(targetLevel) - currentXp;
                if (requiredExperience < 0) {
                    SetError(this.getResources().getString(R.string.i_xp));
                    return;
                }
                int requiredActions = (int) Math.ceil(requiredExperience / xpPerAction);
                textViewRequiredActions.setText(String.valueOf(requiredActions).replaceAll("\\.0*$", ""));
                textViewActionsRequired.setText(R.string.required_actions);
                if (timePerAction > 0.0) {
                    double time = requiredActions * timePerAction;
                    int hours = (int) Math.floor(time / 3600);
                    int minutes = (int) Math.floor(((time / 3600) - hours) * 60);
                    int seconds = (int) Math.ceil(((((time / 3600) - hours) * 60) - minutes) * 60);
                    textViewTimeRequired.setText(String.format(Locale.US, "%d%s%d%s%d%s", hours, this.getResources().getString(R.string.hours), minutes, this.getResources().getString(R.string.minutes), seconds, this.getResources().getString(R.string.seconds)));
                    textViewTimeRequiredText.setText(R.string.required_time);
                }
            } else {
                SetError(this.getResources().getString(R.string.i_level));
            }
        });
    }

    private void ClearTime() {
        textViewTimeRequired.setText("");
        textViewTimeRequiredText.setText("");
    }

    private void SetError(String errorMessage) {
        textViewRequiredActions.setText("");
        textViewActionsRequired.setText(errorMessage);
        ClearTime();
    }
}