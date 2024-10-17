package com.breezebiolumeskincare.features.newcollection.model

import com.breezebiolumeskincare.app.domain.CollectionDetailsEntity
import com.breezebiolumeskincare.base.BaseResponse
import com.breezebiolumeskincare.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}