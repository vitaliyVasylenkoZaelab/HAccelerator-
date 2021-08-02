
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

$contentCatalog=apparel-ukContentCatalog
$contentCV=catalogVersion(CatalogVersion.catalog(Catalog.id[default=$contentCatalog]),CatalogVersion.version[default=Staged])[default=$contentCatalog:Staged]
 $productCV=catalogVersion(catalog(id[default=$productCatalog]),version[default='Staged'])[unique=true,default=$productCatalog:Staged]
 $category=category(code, $productCV)
$productCatalog=apparelProductCatalog
$productCatalogName=Apparel Product Catalog
$lang=en
$picture=media(code, $contentCV) ;
$siteResource=jar:de.hybris.platform.apparelstore.constants.ApparelstoreConstants&/apparelstore/import/sampledata/contentCatalogs/$contentCatalog
$jarResourceCms=jar:de.hybris.platform.apparelstore.constants.ApparelstoreConstants&/apparelstore/import/sampledata/cockpits/cmscockpit

# Load the storefront context root config param
$storefrontContextRoot=$config-storefrontContextRoot

INSERT_UPDATE CMSLinkComponent;$contentCV[unique=true];uid[unique=true];name;url;&linkRef;&componentRef;target(code)[default='sameWindow'];$category;
;;MenOfferLink;Men Offer Link;/MenOfferLink;MenOfferLink;MenOfferLink;;;;
;;WomenOfferLink;Women Offer Link;/WomenOfferLink;WomenOfferLink;WomenOfferLink;;;;
;;KidsOfferLink;Kids Offer Link;/KidsOfferLink;KidsOfferLink;KidsOfferLink;;;;


INSERT_UPDATE Media;$contentCV[unique=true];code[unique=true];@media[translator=de.hybris.platform.impex.jalo.media.MediaDataTranslator];mime[default='image/jpeg'];&imageRef;folder(qualifier)[default='images'];altText
;;customOffersMedia;$siteResource/images/banners/homepage/offers.jpeg;;offers.jpeg;;

INSERT_UPDATE CustomOffersComponent;$contentCV[unique=true];uid[unique=true];name;headrerText[lang=$lang];footerText[lang=$lang];offerImage(code);&componentRef;offerImageLink(&linkRef);
;;summerOfferComponent;Summer offer Component;"up to 70 % off";"Grab this offer on all summer<br>Collections";customOffersMedia;summerOfferComponent;MenOfferLink,WomenOfferLink,KidsOfferLink

INSERT_UPDATE ContentSlotName;name[unique=true];template(uid,$contentCV)[unique=true][default='LandingPage2Template'];validComponentTypes(code);compTypeGroup(code)
;SummerOffersSlotName;;CustomOffersComponent

INSERT_UPDATE ContentSlot;$contentCV[unique=true];uid[unique=true];name;active;cmsComponents(&componentRef)
;;summerOfferContentSlot;Summer offer slot;true;summerOfferComponent

INSERT_UPDATE ContentSlotForPage;$contentCV[unique=true];uid[unique=true];position[unique=true];page(uid,$contentCV)[unique=true][default='homepage'];contentSlot(uid,$contentCV)[unique=true]
;;summerOfferslotforpage-Homepage;SummerOffersSlotName;;summerOfferContentSlot

INSERT_UPDATE CronJob;code[unique=true];job(code);sessionLanguage(isoCode)[default=en]
;scaleAbortableCronJob;scaleAbortableJob;

INSERT_UPDATE Trigger;cronjob(code)[unique=true];cronExpression
; scaleAbortableCronJob; 0/55 * * * * ?


UPDATE ApparelProduct[batchmode=true];itemtype(code)[unique=true];name
;Order;scaleName

REMOVE scaleItemType;PK[batchmode=true];itemtype(code)[unique=true]
;scaleType

UPDATE ApparelProduct[batchmode=true];scale(code)[unique=true];scale
;NANO;TINY

REMOVE ApparelProduct[batchmode=true];scale(code)[unique=true];scale
;TINY

INSERT_UPDATE Currency[disable.interceptor.types=validate];isocode[unique=true];symbol;digits;
;USD_Test;-2;$

INSERT_UPDATE Currency[disable.interceptor.beans='UserPrepareDefaultInterceptor'];isocode[unique=true];symbol;digits;
;USD_Test;-2;$

INSERT_UPDATE Currency[disable.UniqueAttributeValidator.for.types='Currency'];isocode[unique=true];symbol;digits;
;USD_Test;-2;$

INSERT_UPDATE SerachRestriction;code[unique=true];name[lang=en];principal(UID);restrictedType(code);active;generate;query
;scaleRestriction;scaleRestriction;emploteegroup;Customer;true;true;{uid} !='william.hunter@rustic-hw.com'

select * from {apparelProduct} where {scale} is not null