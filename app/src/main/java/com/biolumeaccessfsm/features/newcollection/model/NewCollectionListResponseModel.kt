package com.biolumeaccessfsm.features.newcollection.model

import com.biolumeaccessfsm.app.domain.CollectionDetailsEntity
import com.biolumeaccessfsm.base.BaseResponse
import com.biolumeaccessfsm.features.shopdetail.presentation.model.collectionlist.CollectionListDataModel

/**
 * Created by Saikat on 15-02-2019.
 */
class NewCollectionListResponseModel : BaseResponse() {
    //var collection_list: ArrayList<CollectionListDataModel>? = null
    var collection_list: ArrayList<CollectionDetailsEntity>? = null
}