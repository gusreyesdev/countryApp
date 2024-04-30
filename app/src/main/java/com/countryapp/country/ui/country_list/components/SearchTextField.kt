package com.countryapp.country.ui.country_list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.countryapp.R

@Composable
fun SearchTextField(query: String, onQueryChanged: (String) -> Unit) {

    OutlinedTextField(
        value = query,
        onValueChange = {onQueryChanged(it)},
        singleLine = true,
        label = { Text(text = stringResource(id = R.string.Search_name)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    )
}