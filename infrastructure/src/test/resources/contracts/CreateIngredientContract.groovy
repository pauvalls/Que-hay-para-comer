import org.springframework.cloud.contract.spec.Contract

Contract.make {

    request {
        method('POST')
        url('/ingredient/save')
        headers {
            contentType(applicationJson())
        }
        body([
                name                : $(anyNonBlankString()),
                nutricionalValuesDTO: [
                        kcal  : $(anyDouble()),
                        grasas: $(anyDouble()),
                        azucar: $(anyDouble())
                ]
        ]
        )
    }
    response {
        status OK()
        headers {
            contentType(applicationJson())
        }
        body([
                id                  : $(anyUuid()),
                name                : $(anyNonBlankString()),
                nutricionalValuesDTO: [
                        kcal  : $(anyDouble()),
                        grasas: $(anyDouble()),
                        azucar: $(anyDouble())
                ]
        ]
        )


    }


}