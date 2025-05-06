package com.example.mobile1project.ids.temps.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobile1project.R
import com.example.mobile1project.ids.temps.viewmodels.TempViewModel
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun TempScreen(tempViewModel: TempViewModel = viewModel()) {
    val resources = LocalContext.current.resources

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
                    painter = painterResource(id = R.drawable.termometro),
            contentDescription = stringResource(id = R.string.image_descript),
            modifier = Modifier
                .size(300.dp)
        )

        Spacer(modifier = Modifier.height(4.dp))

        TextField(
            value = tempViewModel.celsius,
            onValueChange = { tempViewModel.celsius = it },
            label = { Text(stringResource(R.string.celsius_label)) },
            modifier = Modifier.fillMaxWidth(),
            isError = tempViewModel.errorMessage.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(4.dp))

        if (tempViewModel.errorMessage.isNotEmpty()) {
            Text(
                text = tempViewModel.errorMessage,
                color = Color.Red, //
                modifier = Modifier.padding(top = 10.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { tempViewModel.calculateTemp(resources) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            )
        ) {
            Text(text = stringResource(R.string.convert_button))
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (tempViewModel.fahrenheit.isNotEmpty()) {
            Text(
                text = tempViewModel.fahrenheit,
                color = Color(0xFF388E3C)
            )
        }
    }
}