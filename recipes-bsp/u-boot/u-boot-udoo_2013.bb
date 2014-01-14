require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=6bc50ecab884fce80cd3ef3da8852b08"

SRC_URI[md5sum] = "c0f064a9e9d1eb3c91ab166a631af080"
SRC_URI[sha256sum] = "46273bb1da340814451ef781ee7fba50faf44541c694e2d333d5f351f691d6fa"

COMPATIBLE_MACHINE = "(mx6)"
DEPENDS_mxs += "elftosb-native openssl-native"
PROVIDES += "u-boot"
PV="unico2013"

SRCREV = "b48999bc21243676a80f94ff1d2cd78418aca013"
SRC_URI = "git://github.com/UDOOboard/U-Boot_Unico-2013.git \
	   file://0001-modified-UDOO-conf-for-yocto-meta.patch"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += 'HOSTCC="${BUILD_CC} ${BUILD_CPPFLAGS}" \
                 HOSTLDFLAGS="-L${STAGING_BASE_LIBDIR_NATIVE} -L${STAGING_LIBDIR_NATIVE}" \
                 HOSTSTRIP=true'

PACKAGE_ARCH = "${MACHINE_ARCH}"
