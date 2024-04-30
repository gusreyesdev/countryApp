package com.countryapp.country.ui.country_detail.components


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.countryapp.R
import com.countryapp.country.domain.model.Country
import java.text.NumberFormat
import java.util.Locale

@Composable
fun CountryDetailListItem(
    country: Country
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {

        AsyncImage(
            model = country.flags?.png,
            contentDescription = country.name?.common,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = country.name?.official ?: "",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxSize()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.Capital),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxSize()
        )

        country.capital?.forEach { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.Continent),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxSize()
        )

        Text(
            text = country.region + " - " + country.subregion,
            modifier = Modifier
                .fillMaxSize()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.Status),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxSize()
        )

        country.status?.let { Text(text = it , modifier = Modifier.fillMaxSize() ) }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.Fifa),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxSize()
        )

        country.fifa?.let { Text(text = it, modifier = Modifier.fillMaxSize() ) }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = stringResource(id = R.string.Population),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxSize()
        )

        country.population?.let {
            Text(
                text = NumberFormat.getInstance(Locale.US).format( it.toIntOrNull())  ,
                modifier = Modifier
                    .fillMaxSize()
            )
        }


    }
}