
put your configuration files here.
(local.properties, localextensions.xml)

$productCatalog=apparelProductCatalog
$productCatalogName=Apparel Product Catalog
$catalogVersion=catalogversion(catalog(id[default=$productCatalog]),version[default='Staged'])[unique=true,default=$productCatalog:Staged]
$baseProduct=baseProduct(code, catalogVersion(catalog(id[default='$productCatalog']),version[default='Staged']))
$approved=approvalstatus(code)[default='approved']
$taxGroup=Europe1PriceFactory_PTG(code)[default=eu-vat-full]

INSERT_UPDATE ApparelProduct;code[unique=true];$catalogVersion;scale
;M33477_B;;BIG
;29533;;MEDIUM
;45572;;SMALL
;300046587;;BIG

INSERT_UPDATE ApparelProduct;pk[unique=true];code;scale
;8796158066689;300310300;SMALL
;8796094431233;300310300;SMALL


;8796094693377;M33477_B;BIG
;8796160098305;M33477_B;BIG
;8796093251585;45572;SMALL
;8796156690433;45572;SMALL
;8796094103553;300046587;MEDIUM
;8796157739009;300046587;MEDIUM

$productCatalog=apparelProductCatalog
$catalogVersions=catalogVersions(catalog(id),version);
$facetSearchConfigName=apparel-ukIndex
$facetSearchConfigDescription=Apparel UK Solr Index
$searchIndexNamePrefix=apparel-uk
$solrIndexedType=apparel-ukProductType
$indexBaseSite=apparel-uk
$indexLanguages=en
$indexCurrencies=GBP

INSERT_UPDATE SolrIndexedProperty;solrIndexedType(identifier)[unique=true];name[unique=true];type(code);sortableType(code);currency[default=false];localized[default=false];multiValue[default=false];useForSpellchecking[default=false];useForAutocomplete[default=false];fieldValueProvider;valueProviderParameters[map-delimiter=|];ftsPhraseQuery[default=false];ftsPhraseQueryBoost;ftsQuery[default=false];ftsQueryBoost;ftsFuzzyQuery[default=false];ftsFuzzyQueryBoost;ftsWildcardQuery[default=false];ftsWildcardQueryType(code)[default=POSTFIX];ftsWildcardQueryBoost;ftsWildcardQueryMinTermLength
;$solrIndexedType;scale;string;;;;;;;;;;;;;;;;;;


$productCatalog=apparelProductCatalog
$catalogVersions=catalogVersions(catalog(id),version);
$facetSearchConfigName=apparel-ukIndex
$facetSearchConfigDescription=Apparel UK Solr Index
$searchIndexNamePrefix=apparel-uk
$solrIndexedType=apparel-ukProductType
$indexBaseSite=apparel-uk
$indexLanguages=en
$indexCurrencies=GBP

INSERT_UPDATE SolrSearchQueryProperty;indexedProperty(name, solrIndexedType(identifier))[unique=true] ; searchQueryTemplate(name, indexedType(identifier))[unique=true][default=DEFAULT:$solrIndexedType] ; facet ; ftsPhraseQuery[default=false] ; ftsPhraseQueryBoost ; ftsQuery[default=false] ; ftsQueryBoost ; ftsFuzzyQuery[default=false] ; ftsFuzzyQueryBoost ; ftsWildcardQuery[default=false] ; ftsWildcardQueryType(code)[default=POSTFIX] ; ftsWildcardQueryBoost ; ftsWildcardQueryMinTermLength ; includeInResponse[default=true] ; useForHighlighting[default=false]
;scale:$solrIndexedType;;;;;;;;;;;;;;


<bean class="de.hybris.platform.commerceservices.search.solrfacetsearch.querybuilder.impl.DefaultFreeTextQueryBuilder">
					<property name="propertyName" value="scale" />
					<property name="boost" value="90" />
				</bean>
