package com.zzz.dialonative.feature_contact.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zzz.dialonative.R
import com.zzz.dialonative.feature_contact.domain.model.Contact
import com.zzz.dialonative.ui.theme.DialoNativeTheme
import com.zzz.dialonative.ui.theme.darkOnBackground
import com.zzz.dialonative.ui.theme.darkOnCreate

@Composable
fun ContactListItem(
    contact: Contact,
    showNumber : Boolean = false,
    modifier: Modifier = Modifier
) {
    Row(
        modifier.fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(topEnd = 25.dp, bottomStart = 25.dp, bottomEnd =25.dp ))
            .background(darkOnCreate)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        //Image and name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            ContactListImage(firstLetter = contact.name.take(1), color = contact.color)
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    contact.name ,
                    fontSize = 18.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = darkOnBackground
                )
                if(showNumber){
//                    VerticalSpace(4.dp)
                    Text(
                        contact.phone ,
                        fontSize = 13.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = darkOnBackground
                    )
                }
            }

        }
        //Call ICON
        Box(
            Modifier.size(40.dp)
                .clip(CircleShape)
                .background(Color.DarkGray)
                .clickable {

                }.padding(4.dp)
                ,
            contentAlignment = Alignment.Center
        ){
            Icon(
                painter = painterResource(R.drawable.phone_icon) ,
                contentDescription = "Call ${contact.name}",
                modifier = Modifier.fillMaxSize(),
                tint = darkOnBackground.copy(alpha = 0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemPrev() {
    DialoNativeTheme {
        ContactListItem(
            contact = Contact(contactId = 2, color = Color.Red.toArgb(), name = "Atharva P")
        )
    }
}

