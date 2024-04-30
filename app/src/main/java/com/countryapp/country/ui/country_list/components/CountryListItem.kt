package com.countryapp.country.ui.country_list.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.countryapp.country.domain.model.Country

@Composable
fun CountryListItem(
    country: Country,
    onItemClick: (Country) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(country) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        AsyncImage(
            model = country.flags?.png,
            contentDescription = country.name?.common,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(60.dp)
        )

        Column {
            Text(
                text = country.name?.common ?: "",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 5.dp)
            )

            country.capital?.forEach { item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 5.dp)
                )
            }
        }
    }
}