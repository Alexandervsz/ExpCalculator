package com.example.expcalculator;

import static java.util.Map.entry;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;
import java.util.Map;


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
        Map<Integer, Integer> expTable = Map.<Integer, Integer>ofEntries(
                entry(2, 83),
                entry(3, 174),
                entry(4, 276),
                entry(5, 388),
                entry(6, 512),
                entry(7, 650),
                entry(8, 801),
                entry(9, 969),
                entry(10, 1154),
                entry(11, 1358),
                entry(12, 1584),
                entry(13, 1833),
                entry(14, 2107),
                entry(15, 2411),
                entry(16, 2746),
                entry(17, 3115),
                entry(18, 3523),
                entry(19, 3973),
                entry(20, 4470),
                entry(21, 5018),
                entry(22, 5624),
                entry(23, 6291),
                entry(24, 7028),
                entry(25, 7842),
                entry(26, 8740),
                entry(27, 9730),
                entry(28, 10824),
                entry(29, 12031),
                entry(30, 13363),
                entry(31, 14833),
                entry(32, 16456),
                entry(33, 18247),
                entry(34, 20224),
                entry(35, 22406),
                entry(36, 24815),
                entry(37, 27473),
                entry(38, 30408),
                entry(39, 33648),
                entry(40, 37224),
                entry(41, 41171),
                entry(42, 45529),
                entry(43, 50339),
                entry(44, 55649),
                entry(45, 61512),
                entry(46, 67983),
                entry(47, 75127),
                entry(48, 83014),
                entry(49, 91721),
                entry(50, 101333),
                entry(51, 111945),
                entry(52, 123660),
                entry(53, 136594),
                entry(54, 150872),
                entry(55, 166636),
                entry(56, 184040),
                entry(57, 203254),
                entry(58, 224466),
                entry(59, 247886),
                entry(60, 273742),
                entry(61, 302288),
                entry(62, 333804),
                entry(63, 368599),
                entry(64, 407015),
                entry(65, 449428),
                entry(66, 496254),
                entry(67, 547953),
                entry(68, 605032),
                entry(69, 668051),
                entry(70, 737627),
                entry(71, 814445),
                entry(72, 899257),
                entry(73, 992895),
                entry(74, 1096278),
                entry(75, 1210421),
                entry(76, 1336443),
                entry(77, 1475581),
                entry(78, 1629200),
                entry(79, 1798808),
                entry(80, 1986068),
                entry(81, 2192818),
                entry(82, 2421087),
                entry(83, 2673114),
                entry(84, 2951373),
                entry(85, 3258594),
                entry(86, 3597792),
                entry(87, 3972294),
                entry(88, 4385776),
                entry(89, 4842295),
                entry(90, 5346332),
                entry(91, 5902831),
                entry(92, 6517253),
                entry(93, 7195629),
                entry(94, 7944614),
                entry(95, 8771558),
                entry(96, 9684577),
                entry(97, 10692629),
                entry(98, 11805606),
                entry(99, 13034431),
                entry(100, 14391160),
                entry(101, 15889109),
                entry(102, 17542976),
                entry(103, 19368992),
                entry(104, 21385073),
                entry(105, 23611006),
                entry(106, 26068632),
                entry(107, 28782069),
                entry(108, 31777943),
                entry(109, 35085654),
                entry(110, 38737661),
                entry(111, 42769801),
                entry(112, 47221641),
                entry(113, 52136869),
                entry(114, 57563718),
                entry(115, 63555443),
                entry(116, 70170840),
                entry(117, 77474828),
                entry(118, 85539082),
                entry(119, 94442737),
                entry(120, 104273167)
        );
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
                float requiredExperience = expTable.get(targetLevel) - currentXp;
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