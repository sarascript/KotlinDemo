package es.sarascript.retrofitdemo

class ItemMapper {

    fun transform(items: List<ItemDto>): List<ItemModel> {
        return items.map { transform(it) }
    }

    fun transform(item: ItemDto): ItemModel {
        return ItemModel(item.item,
        item.business,
        item.farmerId,
        item.category,
        item.l,
        item.farmName,
        item.phone1)
    }

}